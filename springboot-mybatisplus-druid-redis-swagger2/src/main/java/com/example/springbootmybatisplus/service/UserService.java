package com.example.springbootmybatisplus.service;

import com.example.springbootmybatisplus.entity.User;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author baochengkang
 * @since 2020-06-18
 */
public interface UserService extends IService<User> {

  List<User> getUserAll();

  IPage<User> getPage(Page<User> userpage);
}
