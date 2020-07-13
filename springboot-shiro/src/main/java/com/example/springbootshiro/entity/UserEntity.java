package com.example.springbootshiro.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "t_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity implements Serializable {

  /**
  *
  */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String userName;
  String password;

  @Transient
  String token;
}
