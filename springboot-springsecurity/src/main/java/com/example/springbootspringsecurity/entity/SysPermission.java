package com.example.springbootspringsecurity.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

/**
 * 权限实体类
 * 
 * @author jitwxs
 * @since 2018/5/15 18:11
 */
@Data
public class SysPermission implements Serializable {
  static final long serialVersionUID = 1L;

  private Integer id;

  private String url;

  private Integer roleId;

  private String permission;

  private List permissions;

  // 省略除permissions外的getter/setter

  public List getPermissions() {
    return Arrays.asList(this.permission.trim().split(","));
  }

  public void setPermissions(List permissions) {
    this.permissions = permissions;
  }
}
