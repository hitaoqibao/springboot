package com.example.springbootmybatisplus.dao;

import com.example.springbootmybatisplus.entity.User;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author baochengkang
 * @since 2020-06-17
 */

public interface UserMapper extends BaseMapper<User> {

  List<User> getUser();
}
