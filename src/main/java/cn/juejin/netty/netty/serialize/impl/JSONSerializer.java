package cn.juejin.netty.netty.serialize.impl;

import cn.juejin.netty.netty.serialize.Serializer;
import cn.juejin.netty.netty.serialize.SerializerAlogrithm;
import com.alibaba.fastjson.JSON;

/**
 * @author pengfei.zhao
 * @date 2021/1/2 14:10
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlogrithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
