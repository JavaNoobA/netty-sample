package cn.juejin.netty.netty.protocol.command;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 14:05
 */
public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;
}
