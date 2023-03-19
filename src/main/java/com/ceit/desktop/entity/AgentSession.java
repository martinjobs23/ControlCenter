package com.ceit.desktop.entity;

import io.netty.channel.ChannelHandlerContext;

public class AgentSession {
    public String AgentId;
    public ChannelHandlerContext Context;

    public String getAgentId() {
        return AgentId;
    }

    public AgentSession(String agentId, ChannelHandlerContext context) {
        AgentId = agentId;
        Context = context;
    }

    public void setAgentId(String agentId) {
        AgentId = agentId;
    }

    public ChannelHandlerContext getContext() {
        return Context;
    }

    public void setContext(ChannelHandlerContext context) {
        Context = context;
    }
}
