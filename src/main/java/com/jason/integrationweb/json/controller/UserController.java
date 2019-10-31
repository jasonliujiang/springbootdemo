package com.jason.integrationweb.json.controller;

import com.jason.integrationweb.json.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController
public class UserController {
    //@ResponseBody
    @GetMapping("/user")
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0;i<10;i++){
            User user = new User();
            user.setAddress("北京");
            user.setId(i);
            user.setUserName("jason"+i);
            user.setBirthday(new Date());
            users.add(user);
        }
        return users;
    }

}
