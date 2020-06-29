package com.example.springbootdemo.serviceImpl;

import java.util.List;

import com.example.springbootdemo.dao.UserMapper;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.result.ResultBean;
import com.example.springbootdemo.result.ResultFactory;
import com.example.springbootdemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserMapper userMapper;

  @Override
  public ResultBean getUserAll(User user) {
    // TODO Auto-generated method stub
    ResultBean rb = null;
    boolean tf = false;
    String username = user.getUsername();
    String password = user.getPassword();
    List<User> list = userMapper.selectAll();
    for (int i = 0; i < list.size(); i++) {
      if (username.equals(list.get(i).getUsername())) {
        tf = true;
        if (password.equals(list.get(i).getPassword())) {
      //{"code":20000,"data":{"token":"admin-token"}}
          rb = ResultFactory.buildSuccessResult(username, "登录成功");
        } else {
          rb = ResultFactory.buildFailResult("密码错误，请重新输入");
        }
      }
    }
    if (!tf) {
      rb = ResultFactory.buildFailResult("用户不存在");
    }
    return rb;
  }

}