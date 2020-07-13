package com.example.springbootspringsecurity.service;

import java.util.List;

import com.example.springbootspringsecurity.entity.SysUserRole;
import com.example.springbootspringsecurity.mapper.SysUserRoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserRoleService {
  @Autowired
  private SysUserRoleMapper userRoleMapper;

  public List<SysUserRole> listByUserId(Integer userId) {
    return userRoleMapper.listByUserId(userId);
  }
}
