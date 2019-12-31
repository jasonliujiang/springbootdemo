package com.jason.persistent.redis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisLockUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 加锁
     *
     * @param key
     * @param value
     * @return
     */
    public boolean lock(String key, String value) {
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        //获取key的值，判断是否超时
        String curVal = (String) redisTemplate.opsForValue().get(key);
        if (StringUtils.isNotEmpty(curVal) && Long.parseLong(curVal) < System.currentTimeMillis()) {
            String oldVal = (String) redisTemplate.opsForValue().getAndSet(key, value);
            if (StringUtils.isNotEmpty(oldVal) && oldVal.equals(curVal)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @param
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = (String) redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            log.error("redis分布式锁解锁异常，{}", e);
        }
    }

}
