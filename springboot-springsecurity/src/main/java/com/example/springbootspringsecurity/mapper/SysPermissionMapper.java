package com.example.springbootspringsecurity.mapper;

import java.util.List;

import com.example.springbootspringsecurity.entity.SysPermission;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysPermissionMapper {
  @Select("SELECT * FROM sys_permission WHERE role_id=#{roleId}")
  List<SysPermission> listByRoleId(Integer roleId);
}