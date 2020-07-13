package com.example.springbootshiro.dao;

import com.example.springbootshiro.entity.TUser;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-10
 */
public interface TUserMapper extends BaseMapper<TUser> {

  TUser findUser(String username);

  TUser selectById(Long id);
}
