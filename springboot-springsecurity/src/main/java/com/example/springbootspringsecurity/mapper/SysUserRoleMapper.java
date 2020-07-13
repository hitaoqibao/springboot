package com.example.springbootspringsecurity.mapper;

import java.util.List;

import com.example.springbootspringsecurity.entity.SysUserRole;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserRoleMapper {
  @Select("SELECT * FROM sys_user_role WHERE user_id = #{userId}")
  List<SysUserRole> listByUserId(Integer userId);
}
