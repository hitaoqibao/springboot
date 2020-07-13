package com.example.springbootshiro.service.impl;

import com.example.springbootshiro.entity.TUser;
import com.example.springbootshiro.dao.TUserMapper;
import com.example.springbootshiro.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-10
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

  @Autowired
  TUserMapper tusermapper;

  @Override
  public TUser findUserAll(String username) {
    // TODO Auto-generated method stub
    TUser tuser = tusermapper.findUser(username);
    return tuser;
  }

}
