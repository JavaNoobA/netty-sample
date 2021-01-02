package cn.juejin.netty.netty.attr;

import io.netty.util.AttributeKey;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 15:19
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
}
