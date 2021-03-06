package com.example.springbootshiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TUser implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private String password;

  private String userName;

  @Transient
  String token;
}
