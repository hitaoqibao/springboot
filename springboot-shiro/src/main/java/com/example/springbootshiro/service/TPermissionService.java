package com.example.springbootshiro.service;

import com.example.springbootshiro.entity.TPermission;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-10
 */
public interface TPermissionService extends IService<TPermission> {

  List<TPermission> findByUserIdAll(Long userid);
}
