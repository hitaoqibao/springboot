package com.example.springbootshiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.springbootshiro.entity.PermissionEntity;

public interface PermissionRepsitory extends JpaRepository<PermissionEntity, Long> {
  List<PermissionEntity> findByUserId(Long userId);
}