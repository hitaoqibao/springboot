package com.example.springbootdemo.service;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.result.ResultBean;

public interface UserService {
  ResultBean getUserAll(User user);
}