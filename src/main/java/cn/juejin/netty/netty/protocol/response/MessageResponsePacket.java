package cn.juejin.netty.netty.protocol.response;

import cn.juejin.netty.netty.protocol.Packet;
import cn.juejin.netty.netty.protocol.command.Command;
import lombok.Data;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 15:16
 */
@Data
public class MessageResponsePacket extends Packet {
    private String message;
    private String fromUserId;
    private String fromUserName;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
