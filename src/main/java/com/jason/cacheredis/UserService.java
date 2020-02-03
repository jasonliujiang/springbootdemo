package com.jason.cacheredis;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
//@CacheConfig(cacheNames = "c1")
public class UserService {

    //配置缓存，方法的参数为key,方法的返回值为value，如果方法的调用参数一样， 直接就会返回值而不会再调用这个方法了
    @Cacheable(cacheNames = "c1")
    public User greUserById(Integer id){
        System.out.println("getUserById>>>"+id);
        User user = new User();
        user.setId(id);
        return user;
    }

    /**
     * 删除数据的时候缓存的数据一并删除
     * @param id
     *
     */
    @CacheEvict(cacheNames = "c1")
    public void deleteUserById(Integer id){
        System.out.println("getUserById>>>"+id);
    }

    /**
     * 更新数据的时候更新缓存
     * @param id
     * @return
     */
    @CachePut(cacheNames = "c1")
    public User uodateUserById(Integer id){
        User user = new User();
        user.setId(id);
        user.setUsername("jason");
        return user;
    }


}
