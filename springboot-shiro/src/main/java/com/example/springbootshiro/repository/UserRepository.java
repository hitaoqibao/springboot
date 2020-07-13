package com.example.springbootshiro.repository;

import com.example.springbootshiro.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findFirstByUserName(String userName);
}