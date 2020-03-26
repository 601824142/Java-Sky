package com.wan.dao;

import com.wan.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper
{


    Integer insertUser(@Param("user") User user);

    User getUser(@Param("userId") Integer userId);

    Integer deleteUser(@Param("userId") Integer userId);

    List<User> getUserList(@Param("userIdList") List<Integer> userIdList);
}