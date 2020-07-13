package com.example.springbootspringsecurity.service;

import com.example.springbootspringsecurity.entity.SysRole;
import com.example.springbootspringsecurity.mapper.SysRoleMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {
  @Autowired
  private SysRoleMapper roleMapper;

  public SysRole selectById(Integer id) {
    return roleMapper.selectById(id);
  }

  public SysRole selectByName(String name) {
    return roleMapper.selectByName(name);
  }
}
