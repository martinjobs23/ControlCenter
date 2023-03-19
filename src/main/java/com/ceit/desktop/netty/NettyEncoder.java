package com.ceit.desktop.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

//编码器

public class NettyEncoder extends MessageToByteEncoder<EncoderOrDecoder> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, EncoderOrDecoder msg, ByteBuf byteBuf) throws Exception {
        //返回数据也是TLV格式
        //前两个字节为T
        //第一个字节为plugin_type
        byteBuf.writeByte(msg.getPlugin_type());
        //第二个字节为msg_type
        byteBuf.writeByte(msg.getMsg_type());
        //第三、四个字节为length
        byteBuf.writeByte(msg.getLength()/256);
        byteBuf.writeByte(msg.getLength()%256);
        //之后为序列化后的数据
        byteBuf.writeBytes(msg.getContent());
    }
}
