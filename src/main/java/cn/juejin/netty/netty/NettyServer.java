package cn.juejin.netty.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.AttributeKey;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 9:31
 */
public class NettyServer {

    public static final int BEGIN_PORT = 8000;

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap
                // 配置两大线程组, 定型引导类的线程模型
                .group(boss, worker)

                // 指定 IO 模型为 NIO
                .channel(NioServerSocketChannel.class)

                // 为服务端 channel(NioServerSocketChannel) 指定自定义属性
                .attr(AttributeKey.newInstance("serverName"), "nettyServer")

                // 开启 TCP 底层心跳
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // 开启 Nagle 算法
                .childOption(ChannelOption.TCP_NODELAY, true)

                // 泛型参数 NioSocketChannel, Netty 对 NIO 类型的连接的抽象
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                });

        bind(serverBootstrap, BEGIN_PORT);
    }

    public static void bind(ServerBootstrap serverBootstrap, int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口[" + port + "]绑定成功");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
                bind(serverBootstrap, port + 1);
            }
        });
    }
}
