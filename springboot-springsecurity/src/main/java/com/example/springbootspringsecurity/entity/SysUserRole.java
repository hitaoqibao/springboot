package com.example.springbootspringsecurity.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysUserRole implements Serializable {
  static final long serialVersionUID = 1L;

  private Integer userId;

  private Integer roleId;

}
