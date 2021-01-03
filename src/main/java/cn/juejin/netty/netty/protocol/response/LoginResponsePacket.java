package cn.juejin.netty.netty.protocol.response;

import cn.juejin.netty.netty.protocol.Packet;
import cn.juejin.netty.netty.protocol.command.Command;
import lombok.Data;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 14:50
 */
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;

    private String username;

    private String userId;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
