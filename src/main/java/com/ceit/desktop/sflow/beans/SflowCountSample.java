package com.ceit.desktop.sflow.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SflowCountSample {
    public String agentIp;      //sflow agent ip
    public long sysUptime;      //设备启动秒数
    public int ifIndex;         //接口的索引值
    public int ifType;          //接口的类型
    public long inOct;          //接收的字节数
    public long inPkt;          //接收的报文数
    public long inMtcPkt;       //接收的组播报文数
    public long inBroPkt;       //接收的广播的报文数
    public long outOct;
    public long outPkt;
    public long outMtcPkt;
    public long outBroPkt;
    public long seqNumber;      //报文序列号

    public String toString(){
        return "{\"agentIp:\"" + agentIp + "\"sysUptime:\"" + sysUptime+ "\"ifIndex:\"" + ifIndex + "\"ifType:\"" + ifType + "\"inOct:\"" + inOct + "\"inPkt:\"" + inPkt + "\"inMtcPkt:\"" + inMtcPkt + "\"inBroPkt:\"" + inBroPkt
        + "\"outOct:\"" + outOct + "\"outPkt:\"" + outPkt + "\"outMtcPkt:\"" + outMtcPkt + "\"outBroPkt:\"" + outBroPkt + "\"seqNum:\"" + seqNumber + "}";
    }
}
