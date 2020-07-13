package com.example.springbootspringsecurity.service;

import java.util.List;

import com.example.springbootspringsecurity.entity.SysPermission;
import com.example.springbootspringsecurity.mapper.SysPermissionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionService {
  @Autowired
  private SysPermissionMapper permissionMapper;

  /**
   * 获取指定角色所有权限
   */
  public List<SysPermission> listByRoleId(Integer roleId) {
    return permissionMapper.listByRoleId(roleId);
  }
}