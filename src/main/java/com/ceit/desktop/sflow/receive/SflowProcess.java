package com.ceit.desktop.sflow.receive;

import com.ceit.desktop.sflow.analyze.SflowCountersSampleMethod;
import com.ceit.desktop.sflow.analyze.SflowFlowSampleMethod;
import com.ceit.desktop.sflow.analyze.SflowSampleMethod;
import com.ceit.desktop.sflow.beans.SflowCountSample;
import com.ceit.desktop.sflow.beans.SflowHeader;
import com.ceit.desktop.utils.JdbcUtil;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SflowProcess {
    private DatagramSocket socket = null;
    private DataInputStream dis = null;

    private JdbcUtil jdbcUtil = null;

    public void init(int port){
        try {
            //创建监听
            socket = new DatagramSocket(port);
            jdbcUtil = new JdbcUtil();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void SflowProcessStart() throws IOException {
        byte[] buf = new byte[2048];
        while(true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            dis = new DataInputStream(new ByteArrayInputStream(packet.getData()));
            String agentIp = null;
            long sysUptime = 0;
            SflowHeader sflowHeader = null;
            SflowCountSample sflowCountSample = new SflowCountSample();
            try {
                sflowHeader = SflowSampleMethod.getSflowHeader(dis);
                agentIp = sflowHeader.getIp();
                sysUptime = sflowHeader.getSysUptimelong();
                sflowCountSample.setAgentIp(agentIp);
                sflowCountSample.setSysUptime(sysUptime);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            // sflow具体信息
            int NumSamples = sflowHeader.getNumSamples();
            // 循环遍历sflow包中包含的所有元素
            while (NumSamples > 0) {
                // 此处为3代表 expanded flow sample 字段
                // 此处为4代表expanded counters sample字段
                try {
                    int tag = dis.readInt();
                    if (tag == 4) {
                        SflowCountersSampleMethod.getCountersSampleData(dis, sflowHeader,sflowCountSample);
                    }

                    if (tag == 3) {
                        /***** 获取flow sample头信息 ******/
                        SflowFlowSampleMethod.getFlowSampleData(dis, sflowHeader);
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
                NumSamples--;
            }
            //System.out.println(sflowCountSample);
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String check_time = simpleDateFormat.format(date);

            String insertsql = "insert into dev_sflow_counter(agent_ip,sys_uptime,if_index,if_type,in_oct,in_pkt,in_mtcpkt,in_bropkt,out_oct,out_pkt,out_mtcpkt,out_bropkt,seqnumber,time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            int res = jdbcUtil.executeUpdate(insertsql,sflowCountSample.agentIp,sflowCountSample.sysUptime,sflowCountSample.ifIndex,sflowCountSample.ifType,
                    sflowCountSample.inOct,sflowCountSample.inPkt,sflowCountSample.inMtcPkt,sflowCountSample.inBroPkt,
                    sflowCountSample.outOct,sflowCountSample.outPkt,sflowCountSample.outMtcPkt,sflowCountSample.outBroPkt,sflowCountSample.seqNumber,check_time);
        }
    }
}
