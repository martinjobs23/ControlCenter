package com.ceit.desktop.netty;

import com.ceit.desktop.entity.AgentSession;
import com.ceit.desktop.netty.PluginManager;
import com.ceit.desktop.utils.AgentStatusUtil;
import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class AgentSessionManager {

    private AgentStatusUtil agentStatusUtil = new AgentStatusUtil();

    //终端会话表 key: agentId  --> value: AgentSession
    private static Hashtable agentSessionTable = new Hashtable();

    private static PluginManager _pluginManager = null;

    public void setPluginManager(PluginManager pluginManager){
        _pluginManager = pluginManager;
    }

    public void initAllAgentSessionOnline(){
        agentStatusUtil.updateDeviceStatusAll();
    }

    public AgentSession getAgentSessionByAgentId(String agentId) {
        if (agentSessionTable.containsKey(agentId))
        {
            return (AgentSession)agentSessionTable.get(agentId);
        }
        return null;
    }

    public void ChangeAgentSession(String agentId,AgentSession agentSession){
        if (!agentSessionTable.containsKey(agentId))
        {
            agentSessionTable.put(agentId,agentSession);
        }else{
            AgentSession ctx = (AgentSession)agentSessionTable.get(agentId);
            ctx.getContext().close();
            //System.out.println("11111111111111111111111111111111111111111111111111111111111111111111");
            agentSessionTable.replace(agentId,agentSession);
        }
    }

    //连接关闭
    public void onCloseConnection(String agentId) {
        AgentSession agent = (AgentSession)agentSessionTable.get(agentId);
        if (agent != null)
        {
            //System.out.println("========================================");
            //断开连接，删除会话
            agentSessionTable.remove(agentId);
            //agent.Context.disconnect();
            agent.Context.close();
            agentStatusUtil.updateDeviceStatusById(agentId,0);
        }
    }
}
