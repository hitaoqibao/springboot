package com.example.springbootspringsecurity.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysUser implements Serializable {
  static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  private String password;

}
