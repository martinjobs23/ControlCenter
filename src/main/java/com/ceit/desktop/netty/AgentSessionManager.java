package com.ceit.desktop.netty;

import com.ceit.desktop.entity.AgentSession;
import com.ceit.desktop.netty.PluginManager;
import com.ceit.desktop.utils.AgentStatusUtil;
import io.netty.channel.ChannelHandlerContext;

import java.util.Hashtable;

public class AgentSessionManager {

    private AgentStatusUtil agentStatusUtil = new AgentStatusUtil();

    //终端会话表 key: agentId  --> value: AgentSession
    private static Hashtable agentSessionTable = new Hashtable();

    private static PluginManager _pluginManager = null;

    public void setPluginManager(PluginManager pluginManager){
        _pluginManager = pluginManager;
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
        }
    }

    //连接关闭
    public void onCloseConnection(String agentId) {
        AgentSession agent = (AgentSession)agentSessionTable.get(agentId);
        if (agent != null)
        {
            //断开连接，删除会话
            agentSessionTable.remove(agentId);
            agent.Context.close();
            agentStatusUtil.updateDeviceStatusById(agentId,0);
        }
    }
}
