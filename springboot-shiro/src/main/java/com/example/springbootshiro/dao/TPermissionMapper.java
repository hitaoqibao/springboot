package com.example.springbootshiro.dao;

import com.example.springbootshiro.entity.TPermission;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-10
 */
public interface TPermissionMapper extends BaseMapper<TPermission> {

  List<TPermission> findByUserId(Long userid);

}
