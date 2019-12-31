package com.jason.persistent.mybatis2.mapper2;

import com.jason.persistent.mybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper2 {
    List<User> getAllUsers();
}
