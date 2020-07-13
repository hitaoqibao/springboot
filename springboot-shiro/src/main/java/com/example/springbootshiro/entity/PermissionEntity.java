package com.example.springbootshiro.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_permission")
public class PermissionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  Long userId;
  Long roleId;
}