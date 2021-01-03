package cn.juejin.netty.netty.protocol.request;

import cn.juejin.netty.netty.protocol.Packet;
import cn.juejin.netty.netty.protocol.command.Command;
import lombok.Data;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 15:16
 */
@Data
public class MessageRequestPacket extends Packet {
    private String message;
    private String toUserId;
    private String fromUserName;

    public MessageRequestPacket(String fromUserName, String message) {
        this.fromUserName = fromUserName;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
