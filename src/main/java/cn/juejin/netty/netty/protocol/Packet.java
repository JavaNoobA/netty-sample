package cn.juejin.netty.netty.protocol;

import lombok.Data;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 14:03
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     *
     * @return
     */
    public abstract Byte getCommand();
}
