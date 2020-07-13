package com.example.springbootshiro.service.impl;

import com.example.springbootshiro.entity.TPermission;
import com.example.springbootshiro.dao.TPermissionMapper;
import com.example.springbootshiro.service.TPermissionService;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-10
 */
@Service
public class TPermissionServiceImpl extends ServiceImpl<TPermissionMapper, TPermission> implements TPermissionService {

  @Autowired
  private TPermissionMapper tpermissionmapper;

  @Override
  public List<TPermission> findByUserIdAll(Long userid) {
    // TODO Auto-generated method stub
    List<TPermission> list = tpermissionmapper.findByUserId(userid);
    return list;
  }

}
