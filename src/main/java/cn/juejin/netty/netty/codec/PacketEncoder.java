package cn.juejin.netty.netty.codec;

import cn.juejin.netty.netty.protocol.Packet;
import cn.juejin.netty.netty.protocol.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 19:31
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf out) throws Exception {
        PacketCodeC.INSTANCE.encode(packet, out);
    }
}
