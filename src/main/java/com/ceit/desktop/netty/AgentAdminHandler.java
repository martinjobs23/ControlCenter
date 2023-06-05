package com.ceit.desktop.netty;

import com.ceit.desktop.entity.AgentSession;
import com.ceit.desktop.utils.AgentStatusUtil;
import com.ceit.desktop.utils.JdbcUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

public class AgentAdminHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(AgentAdminHandler.class);

    private static PluginManager pluginManager= new PluginManager();

    private AgentSessionManager _agentSessionManager = null;
    private PluginManager _pluginManager = null;
    private AgentStatusUtil agentStatusUtil = new AgentStatusUtil();

    public void setPluginManager(PluginManager pluginManager){
        _pluginManager = pluginManager;
    }

    public void setAgentSessionManager(AgentSessionManager agentSessionManager)
    {
        _agentSessionManager = agentSessionManager;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        logger.info("deivce {} have channelRegistered",clientIp);
//        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        logger.info("deivce {} have channelUnregistered",clientIp);
//        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { //客户端与服务端第一次建立连接时执行
        int localPort = ((InetSocketAddress) ctx.channel().localAddress()).getPort();
        if(localPort != 50059)
            return;
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        logger.info("deivce {} channelActive",clientIp);
        //System.out.println("????????????????????????????????????????????????????????????????????????????????????????????");
        //System.out.println(ctx);
        String agentId = agentStatusUtil.selectDevIdByIp(clientIp);
        if(agentId.length() == 1){
            ctx.close();
            logger.info("device {} is unregistered,the connection has shut down", clientIp);
            return;
        }
        //根据agentId 查找 终端会话
        AgentSession agent = _agentSessionManager.getAgentSessionByAgentId(agentId);
        if (agent == null){
            //System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
            AgentSession agentSession = new AgentSession(agentId,ctx);
            _agentSessionManager.ChangeAgentSession(agentId,agentSession);
            agentStatusUtil.updateDeviceStatusById(agentId,1);
        } else {
            if (agent.Context.toString() != ctx.toString()){
                //System.out.println("========================================================================================");
                //agent.Context.disconnect();
                //System.out.println(agent.Context);
                //System.out.println(ctx);
                agent.Context.close();
                AgentSession agentSession = new AgentSession(agentId,ctx);
                _agentSessionManager.ChangeAgentSession(agentId,agentSession);
                agentStatusUtil.updateDeviceStatusById(agentId,1);
            }
            //System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            //System.out.println(agent.Context);
        }
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        int localPort = ((InetSocketAddress) ctx.channel().localAddress()).getPort();
        if(localPort != 50059)
            return;

        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
//        ctx.close();
        logger.info("deivce {} channelInactive",clientIp);
        String agentId = agentStatusUtil.selectDevIdByIp(clientIp);
        if(agentId.length() == 1){
            ctx.close();
            logger.info("device {} is unregistered", clientIp);
            return;
        }
        _agentSessionManager.onCloseConnection(agentId);
        super.channelInactive(ctx);
//        ctx.fireChannelInactive();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception { //接收数据时调用

       //获取当前客户端IP
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        //
        EncoderOrDecoder buffer = (EncoderOrDecoder) msg;
        int plugin_type = buffer.getPlugin_type();
        int msg_type =buffer.getMsg_type();
        int length = buffer.getLength();
        byte[] stream = buffer.getContent();
        try
        {
            //根据agentId 查找 终端会话
            String agentId = agentStatusUtil.selectDevIdByIp(clientIp);
            AgentSession agent = _agentSessionManager.getAgentSessionByAgentId(agentId);

            // 分发消息
            EncoderOrDecoder result = pluginManager.DispatchPluginMessage(agent,plugin_type,msg_type, stream,clientIp);
            ctx.write(result);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }



    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception { //接收数据完成时调用
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        logger.info("device {} channelReadComplete",clientIp);
        ctx.flush();
//        super.channelReadComplete(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        ctx.close();
        logger.info("device {} useEventTriggered",clientIp);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {

        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        logger.info("device {} channelWritabilityChanged",clientIp);
//        super.channelWritabilityChanged(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception { //出现异常时调用
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        logger.info("device {} exceptionCaught",clientIp);
        cause.printStackTrace();
        int localPort = ((InetSocketAddress) ctx.channel().localAddress()).getPort();
        if(localPort != 50059){
            ctx.close();//抛出异常，断开与客户端的连接
            return;
        }
        String agentId = agentStatusUtil.selectDevIdByIp(clientIp);
        _agentSessionManager.onCloseConnection(agentId);
        ctx.close();//抛出异常，断开与客户端的连接
//        super.exceptionCaught(ctx, cause);
    }
}
