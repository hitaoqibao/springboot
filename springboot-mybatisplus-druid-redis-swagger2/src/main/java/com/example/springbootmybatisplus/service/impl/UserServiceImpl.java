package com.example.springbootmybatisplus.service.impl;

import com.example.springbootmybatisplus.entity.User;
import com.example.springbootmybatisplus.dao.UserMapper;
import com.example.springbootmybatisplus.service.UserService;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author baochengkang
 * @since 2020-06-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Autowired
  UserMapper userMapper;

  @Override
  public List<User> getUserAll() {
    // TODO Auto-generated method stub
    List<User> list = userMapper.getUser();
    return list;
  }

  @Override
  public IPage<User> getPage(Page<User> userpage) {
    // TODO Auto-generated method stub
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    IPage<User> iPage = userMapper.selectPage(userpage, wrapper);
    return iPage;
  }
}