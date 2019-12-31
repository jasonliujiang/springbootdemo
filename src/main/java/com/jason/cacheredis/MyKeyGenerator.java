package com.jason.cacheredis;


import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *自定义Cache的key值
 * @author liujiang02
 */
@Component
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        return method.getName()+":"+ Arrays.toString(objects);
    }
}
