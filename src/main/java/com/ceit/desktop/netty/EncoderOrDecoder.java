package com.ceit.desktop.netty;

public class EncoderOrDecoder {
    //解码类型

    //plugin_type
    private int plugin_type;
    //msg_type
    private int msg_type;
    //数据长度
    private int length;
    //数据内容
    private byte[] content;

    public EncoderOrDecoder() {
    }

    public EncoderOrDecoder(int plugin_type, int msg_type, int length, byte[] content) {
        this.plugin_type = plugin_type;
        this.msg_type = msg_type;
        this.length = length;
        this.content = content;
    }

    public int getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(int msg_type) {
        this.msg_type = msg_type;
    }

    public int getPlugin_type() {
        return plugin_type;
    }

    public void setPlugin_type(int plugin_type) {
        this.plugin_type = plugin_type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

}
