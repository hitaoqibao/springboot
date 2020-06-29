package com.example.springbootmybatisplus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybatisplus.entity.User;
import com.example.springbootmybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author baochengkang
 * @since 2020-06-17
 */
@RestController
public class UserController {

  @Autowired
  UserService userService;

  @ApiOperation(value = "mybatis-plus原生CRUD")
  @RequestMapping(value = "/test")
  public String test() {
    List<User> list = userService.list();
    String s = JSON.toJSONString(list);
    return s;
  }

  @ApiOperation(value = "手写mapper")
  @RequestMapping("/user")
  public List<User> user() {
    List<User> list = userService.getUserAll();
    return list;
  }

  @ApiOperation(value = "mybatis-plus分页")
  @RequestMapping("/page")
  public IPage<User> page() {
    int pageNo = 2, pageSize = 2;
    Page<User> page = new Page<>(pageNo, pageSize);
    return userService.getPage(page);
  }
}
