package com.example.springbootdemo.dao;

import java.util.List;

import com.example.springbootdemo.model.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectAll();
}