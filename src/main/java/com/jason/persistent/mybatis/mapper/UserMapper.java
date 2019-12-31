package com.jason.persistent.mybatis.mapper;

import com.jason.persistent.mybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author liujiang02
 */
@Mapper
public interface UserMapper {
    List<User> getAllUser();
}
