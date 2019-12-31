package com.jason.cacheredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {
    @Autowired
    UserService userService;


    @Test
    public void cacheRedisTest(){
        User u1 = userService.greUserById(1);
        User u2 = userService.greUserById(1);
        System.out.println(u1);
        System.out.println(u2);


    }
}
