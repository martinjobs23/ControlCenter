package com.ceit.desktop.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.Buffer;
import java.util.List;

//解码器

public class NettyDecoder extends ByteToMessageDecoder {

    //自定义Netty解码器
    /**
     * <pre>
     * 协议开始的标准，int类型，占据4个字节.
     * 表示数据的长度，int类型，占据4个字节.
     * </pre>
     */
    public final int BASE_LENGTH = 4;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf buffer, List<Object> list) throws Exception {
        // 可读长度必须大于基本长度
        if (buffer.readableBytes() >= BASE_LENGTH) {
            //获取plugin_type
            byte[] plugin_bytes = new byte[1];
            buffer.readBytes(plugin_bytes,0,1);
            int plugin_type = plugin_bytes[0];
//            System.out.println("plugin_type: " + plugin_type);

            //获取msg_type
            byte[] msg_bytes = new byte[1];
            buffer.readBytes(msg_bytes,0,1);
            int msg_type = msg_bytes[0];
//            System.out.println("msg_type: " + msg_type);

            //获取length
            byte[] length_bytes = new byte[2];
            buffer.readBytes(length_bytes,0,2);
            int length = length_bytes[0]*256+(length_bytes[1]&0X0FF);
            System.out.println("length:" + length);

            //获取content
            byte[] content_bytes = new byte[length];
            buffer.readBytes(content_bytes);
//            buffer.clear();
            EncoderOrDecoder protocol = new EncoderOrDecoder(plugin_type,msg_type,length,content_bytes);
            list.add(protocol);
        }
    }
}
