package com.jason.persistent.mybatis2.mapper1;

import com.jason.persistent.mybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper1 {
    List<User> getAllUsers();
}
