package cn.juejin.netty.netty.server;

import cn.juejin.netty.netty.protocol.Packet;
import cn.juejin.netty.netty.protocol.PacketCodeC;
import cn.juejin.netty.netty.protocol.request.LoginRequestPacket;
import cn.juejin.netty.netty.protocol.request.MessageRequestPacket;
import cn.juejin.netty.netty.protocol.response.LoginResponsePacket;
import cn.juejin.netty.netty.protocol.response.MessageResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 14:55
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(new Date() + ": 客户端开始登录……");
        ByteBuf requestBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(requestBuf);

        if (packet instanceof LoginRequestPacket) {
            // 登录流程
            LoginRequestPacket requestPacket = (LoginRequestPacket) packet;

            LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
            loginResponsePacket.setVersion(requestPacket.getVersion());
            if (valid(loginResponsePacket)) {
                loginResponsePacket.setSuccess(true);
                System.out.println(new Date() + ": 登录成功!");
            } else {
                loginResponsePacket.setReason("账号密码校验失败");
                loginResponsePacket.setSuccess(false);
                System.out.println(new Date() + ": 登录失败!");
            }

            // 登录响应
            ByteBuf responseBuf = PacketCodeC.INSTANCE.encode(requestPacket, ctx.alloc());
            ctx.channel().writeAndFlush(responseBuf);
        } else if (packet instanceof MessageRequestPacket) {
            MessageRequestPacket messageRequestPacket = ((MessageRequestPacket) packet);
            MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
            System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());
            messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
            ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(messageResponsePacket, ctx.alloc());
            ctx.channel().writeAndFlush(responseByteBuf);
        }
    }

    private boolean valid(LoginResponsePacket loginRequestPacket) {
        return true;
    }
}
