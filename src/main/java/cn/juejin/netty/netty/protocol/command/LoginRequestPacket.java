package cn.juejin.netty.netty.protocol.command;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 14:05
 */
public class LoginRequestPacket extends Packet{
    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
