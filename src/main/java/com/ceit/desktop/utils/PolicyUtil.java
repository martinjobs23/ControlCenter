package com.ceit.desktop.utils;

import com.ceit.desktop.grpc.controlCenter.CheckVersionResponse;

import java.util.List;
import java.util.Map;

public class PolicyUtil {
    private static int devPolicy = 0;
    private static int swChangePolicy = 0;
    private static int swRunPolicy = 0;

    private static int trafficPolicy = 0;

    private static int swChangeMax = 300;
    private static int swRunMax = 100;
    private static int inmax = 10000000;      //暂时不分内网外网  2023-04-14
    private static int outmax = 10000000;

    private static int inpktmax = 10000;      //暂时不分内网外网  2023-05-18

    private static int outpktmax = 10000;

    //public static final int

    public static void setPolicy() {
        JdbcUtil jdbcUtil = new JdbcUtil();
        String sql = "select * from dev_policy ";
        List<Map<String,Object>> list1 = jdbcUtil.executeQuery(sql);
        if(list1.size()!=0){
            Map<String,Object> policyInfo = list1.get(0);
            PolicyUtil.devPolicy = (int) policyInfo.get("dev");
            PolicyUtil.swChangePolicy = (int) policyInfo.get("sw_change");
            PolicyUtil.swRunPolicy = (int) policyInfo.get("sw_run");
            PolicyUtil.trafficPolicy = (int) policyInfo.get("traffic");
            PolicyUtil.swChangeMax = (int) policyInfo.get("sw_change_max");
            PolicyUtil.swRunMax = (int) policyInfo.get("sw_run_max");
            PolicyUtil.inmax = (int) policyInfo.get("flow_in_max");
            PolicyUtil.outmax = (int) policyInfo.get("flow_out_max");
            PolicyUtil.inpktmax = (int) policyInfo.get("pkt_in_max");
            PolicyUtil.outpktmax = (int) policyInfo.get("pkt_out_max");
        }
    }
    public static int setPolicy(int devPolicy, int swChangePolicy, int swRunPolicy, int trafficPolicy){
        JdbcUtil jdbcUtil = new JdbcUtil();
        String updatesql ="update dev_policy set dev = ?, sw_change = ?, sw_run = ?, traffic = ?";
        int res = jdbcUtil.executeUpdate(updatesql,devPolicy,swChangePolicy,swRunPolicy,trafficPolicy);
        setDevPolicy(devPolicy);
        setSwChangePolicy(swChangePolicy);
        setSwRunPolicy(swRunPolicy);
        setTrafficPolicy(trafficPolicy);
        return res;
    }
    public static int setMaxPolicy(int swChangeMax,int swRunMax){
        JdbcUtil jdbcUtil = new JdbcUtil();
        String updatesql ="update dev_policy set sw_change_max = ?, sw_run_max = ?";
        int res = jdbcUtil.executeUpdate(updatesql,swChangeMax,swRunMax);
        setSwChangeMax(swChangeMax);
        setSwRunMax(swRunMax);
        return res;
    }
    public static int setMaxPolicy(int inmax, int outmax,int pktinmax, int pktoutmax){
        JdbcUtil jdbcUtil = new JdbcUtil();
        String updatesql ="update dev_policy set flow_in_max = ?, flow_out_max = ?, pkt_in_max = ?, pkt_out_max = ?";
        int res = jdbcUtil.executeUpdate(updatesql,inmax,outmax,pktinmax,pktoutmax);
        setInmax(inmax);
        setOutmax(outmax);
        setInPktmax(pktinmax);
        setOutPktmax(pktoutmax);
        return res;
    }
    public static void setDevPolicy(int devPolicy) {
        PolicyUtil.devPolicy = devPolicy;
    }

    public static void setSwChangePolicy(int swChangePolicy){
        PolicyUtil.swChangePolicy = swChangePolicy;
    }
    public static void setSwRunPolicy(int swRunPolicy){
        PolicyUtil.swRunPolicy = swRunPolicy;
    }
    public static void setTrafficPolicy(int trafficPolicy){
        PolicyUtil.trafficPolicy = trafficPolicy;
    }
    public static void setSwChangeMax(int swChangeMax){
        PolicyUtil.swRunMax = swChangeMax;
    }
    public static void setSwRunMax(int swRunMax){
        PolicyUtil.swRunMax = swRunMax;
    }
    public static void setInmax(int inmax){
        PolicyUtil.inmax = inmax;
    }
    public static void setOutmax(int outmax){
        PolicyUtil.outmax = outmax;
    }
    public static void setInPktmax(int pktinmax){
        PolicyUtil.inpktmax = pktinmax;
    }
    public static void setOutPktmax(int pktoutmax){
        PolicyUtil.outpktmax = pktoutmax;
    }
    public static int getDevPolicy(){
        return PolicyUtil.devPolicy;
    }
    public static int getSwChangePolicy(){
        return PolicyUtil.swChangePolicy;
    }
    public static int getSwRunPolicy(){
        return PolicyUtil.swRunPolicy;
    }
    public static int getTrafficPolicy(){
        return PolicyUtil.trafficPolicy;
    }
    public static int getSwChangeMax(){
        return PolicyUtil.swChangeMax;
    }
    public static int getSwRunMax(){
        return PolicyUtil.swRunMax;
    }
    public static int getInmax(){
        return PolicyUtil.inmax;
    }
    public static int getOutmax(){
        return PolicyUtil.outmax;
    }
    public static int getInPktmax(){
        return PolicyUtil.inpktmax;
    }
    public static int getOutPktmax(){
        return PolicyUtil.outpktmax;
    }
}
