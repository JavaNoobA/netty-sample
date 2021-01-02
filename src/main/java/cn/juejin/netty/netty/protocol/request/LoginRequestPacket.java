package cn.juejin.netty.netty.protocol.request;

import cn.juejin.netty.netty.protocol.command.Command;
import cn.juejin.netty.netty.protocol.Packet;
import lombok.Data;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 14:05
 */
@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
