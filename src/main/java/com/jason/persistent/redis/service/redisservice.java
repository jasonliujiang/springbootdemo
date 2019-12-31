package com.jason.persistent.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * redis  Demo
 */
@Service
public class redisservice {
    @Autowired
    RedisTemplate redisTemplate;
    public String hello() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("k1", "v1");
        String k1 = (String) ops.get("k1");
        System.out.println(k1);
        return k1;
    }
}
