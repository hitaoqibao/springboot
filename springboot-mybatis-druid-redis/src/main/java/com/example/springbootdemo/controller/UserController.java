package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.result.ResultBean;
import com.example.springbootdemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ResultBean login(@RequestBody User user) {
    ResultBean resultBean = userService.getUserAll(user);
    return resultBean;
  }

  //浏览器输入http://localhost:8000/test?username=%22a%22&password=%22b%22 显示json数据，则连接数据库成功
  @RequestMapping(value = "/test")
  public ResultBean test(String username,String password) {
    User user=new User();
    user.setUsername(username);
    user.setPassword(password);
    ResultBean resultBean = userService.getUserAll(user);
    return resultBean;
  }
}