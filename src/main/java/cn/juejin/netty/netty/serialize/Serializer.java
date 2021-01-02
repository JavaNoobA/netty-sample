package cn.juejin.netty.netty.serialize;

import cn.juejin.netty.netty.serialize.impl.JSONSerializer;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 14:06
 */
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     * @return
     */
    byte getSerializerAlgorithm();

    /**
     * Java 对象转成二进制
     * @param object
     * @return
     */
    byte[] serialize(Object object);

    /**
     * 二进制转成 Java对象
     * @param clazz 目标类
     * @param bytes 二进制数据
     * @param <T> 泛型对象
     * @return 目标类
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
