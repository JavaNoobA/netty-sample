package cn.juejin.netty.netty.attr;

import cn.juejin.netty.netty.session.Session;
import io.netty.util.AttributeKey;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 15:19
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
