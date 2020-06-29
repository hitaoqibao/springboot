package com.example.springbootmybatisplus.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserEntity implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String guid;
  private String name;
  private String age;
  private Date createTime;

}