package com.jason.persistent.jdbctemplate.service;


import com.jason.persistent.mybatis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public Integer addUser(User user){
        //JdbcTemplate  增删改都是用update（）方法
        //添加操作
        return jdbcTemplate.update("insert into user (username,address) values (?,?)",user.getUsername(),user.getAddress());
    }
}
