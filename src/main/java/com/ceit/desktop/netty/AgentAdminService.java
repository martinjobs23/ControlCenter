package com.ceit.desktop.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgentAdminService {

    public static AgentSessionManager agentSessionManager = null;
    public static PluginManager pluginManager = null;
    private int maxLen = 65535;
    //每5 秒检测一次
    int check_conn_interval = 5;
    private Logger logger = LoggerFactory.getLogger(AgentAdminService.class);

    public AgentAdminService() {
        if (agentSessionManager == null)
        {
            agentSessionManager = new AgentSessionManager();
            agentSessionManager.initAllAgentSessionOnline();
        }

        if (pluginManager == null)
        {
            pluginManager = new PluginManager();
            pluginManager.setAgentSessionManager(agentSessionManager);
            pluginManager.LoadPlugins();
        }

        agentSessionManager.setPluginManager(pluginManager);
    }

    public void init(int port) {
        /**
         * 配置服务端的NIO线程组
         * NioEventLoopGroup 是用来处理I/O操作的Reactor线程组
         * bossGroup：用来接收进来的连接，workerGroup：用来处理已经被接收的连接,进行socketChannel的网络读写，
         * bossGroup接收到连接后就会把连接信息注册到workerGroup
         * workerGroup的EventLoopGroup默认的线程数是CPU核数的二倍
         */
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            //ServerBootstrap 是一个启动NIO服务的辅助启动类
            ServerBootstrap bootstrap = new ServerBootstrap();
            //绑定两个线程池,一个监听、处理连接、一个处理I/O操作
            bootstrap.group(bossGroup,workerGroup);
            //设置非阻塞，用来建立新accept连接（channel通道初始化）
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.option(ChannelOption.SO_BACKLOG,100);
            bootstrap.handler(new LoggingHandler("SRV-LSTN"));
            //对出入的数据进行业务操作
//            bootstrap.childHandler(new NioSocketChannelInitializer<SocketChannel>());
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>(){
                @Override
                protected void initChannel(SocketChannel channel) throws Exception {
                    //设置ByteBuf缓存
                    channel.config().setRecvByteBufAllocator(new FixedRecvByteBufAllocator(maxLen));
                    //设置log监听器
                    //channel.pipeline().addLast("loggin",new LoggingHandler("INFO"));
                    //channel.pipeline().addLast(new LoggingHandler("SRV_CONN"));
                    channel.pipeline().addLast("framing-dec",new LengthFieldBasedFrameDecoder(65535,2,2,0,0));
                    channel.pipeline().addLast("decoder",new NettyDecoder());
                    channel.pipeline().addLast("encoder",new NettyEncoder());
                    //心跳监测机制，30秒没有读到数据则触发一个READER_IDLE事件
                    //channel.pipeline().addLast(new IdleStateHandler(60,0,0));
                    //channel.pipeline().addLast("framing-dec",new LengthFieldBasedFrameDecoder(65535,2,2,0,4));

                    AgentAdminHandler handler = new AgentAdminHandler();
                    handler.setAgentSessionManager(agentSessionManager);
                    handler.setPluginManager(pluginManager);
                    channel.pipeline().addLast("OpsServer",handler);
                }
            });
            //服务端绑定监听端口
            Channel channel = bootstrap.bind(port).sync().channel();
            Channel channel1 = bootstrap.bind(port + 250).sync().channel();
            logger.info("start Netty listening on {}",port);
            //是否需要添加取消令牌
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
