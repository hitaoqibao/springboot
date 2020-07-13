package com.example.springbootshiro.service;

import com.example.springbootshiro.entity.TUser;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-10
 */
public interface TUserService extends IService<TUser> {

  TUser findUserAll(String username);
}
