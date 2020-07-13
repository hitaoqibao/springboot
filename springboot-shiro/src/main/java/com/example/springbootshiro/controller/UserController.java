package com.example.springbootshiro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootshiro.constant.ShiroConstant;
import com.example.springbootshiro.dao.TPermissionMapper;
import com.example.springbootshiro.dao.TUserMapper;
import com.example.springbootshiro.entity.PermissionEntity;
import com.example.springbootshiro.entity.TPermission;
import com.example.springbootshiro.entity.TUser;
import com.example.springbootshiro.entity.UserEntity;
import com.example.springbootshiro.repository.PermissionRepsitory;
import com.example.springbootshiro.repository.UserRepository;
import com.example.springbootshiro.service.TPermissionService;
import com.example.springbootshiro.service.TUserService;
import com.example.springbootshiro.util.RedisUtil;
import com.example.springbootshiro.util.TokenUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-10
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private TUserService tUserService;
  @Autowired
  private TPermissionService tPermissionService;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  PermissionRepsitory permissionRepsitory;
  @Autowired
  private TUserMapper tusermapper;
  @Autowired
  private TPermissionMapper tpermissionmapper;

  /**
   * 登录
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public Map<String, Object> login(String username, String password) {
    Map<String, Object> result = new HashMap<>();
    // 用户信息
    TUser user = tUserService.findUserAll(username);
    // 账号不存在、密码错误
    if (user == null) {
      result.put("status", "400");
      result.put("msg", "无该用户");
      return result;
    } else if (!user.getPassword().equals(password)) {
      result.put("status", "400");
      result.put("msg", "账号或密码有误");
      return result;
    } else {
      // 生成token，并保存到reids
      String token = TokenUtil.sign(username, user.getId());
      user.setToken(token);
      RedisUtil.set(ShiroConstant.LOGIN_SHIRO_CACHE + user.getId(), user);
      result.put("token", token);
      result.put("status", "200");
      result.put("msg", "登陆成功");

      return result;
    }
  }

  /**
   * 退出
   */
  @PostMapping("/logout")
  public Map<String, Object> logout() {
    Subject sub = SecurityUtils.getSubject();
    TUser user = (TUser) sub.getPrincipal();
    RedisUtil.del(ShiroConstant.LOGIN_SHIRO_CACHE + user.getId(), ShiroConstant.ROLE_SHIRO_CACHE + user.getId());
    sub.logout();
    Map<String, Object> result = new HashMap<>();
    result.put("status", "200");
    result.put("msg", "登出成功");
    return result;

  }

  // 保存用户
  @PostMapping(value = "/save")
  @RequiresPermissions({ "1" })
  public Map<String, String> saveUser(TUser user) {

    tusermapper.insert(user);
    Map<String, String> result = new HashMap<>();
    result.put("code", "200");
    result.put("msg", "用户操作成功");
    result.put("obj", JSONObject.toJSONString(user));

    return result;
  }

  // 删除用户
  @PostMapping(value = "/del")
  @RequiresPermissions({ "2" })
  public Map<String, String> deleteUser(Long userId) {
    Map<String, String> result = new HashMap<>();

    TUser user = tusermapper.selectById(userId);
    if (user != null) {
      tusermapper.deleteById(userId);
      RedisUtil.del(ShiroConstant.ROLE_SHIRO_CACHE + userId, ShiroConstant.LOGIN_SHIRO_CACHE + userId);
      result.put("code", "200");
      result.put("msg", "用户删除成功");
    } else {
      result.put("code", "400");
      result.put("msg", "没有这个用户");
    }

    return result;
  }

  // 修改用户权限
  @PostMapping(value = "/per")
  @RequiresPermissions({ "3" })
  public Map<String, String> permission(PermissionEntity permissionEntity) {
    Map<String, String> result = new HashMap<>();

    Optional<UserEntity> o = userRepository.findById(permissionEntity.getUserId());
    if (o.isPresent()) {
      RedisUtil.del(ShiroConstant.ROLE_SHIRO_CACHE + permissionEntity.getUserId());
      permissionRepsitory.save(permissionEntity);
      result.put("code", "200");
      result.put("msg", "权限添加成功");
    } else {
      result.put("code", "400");
      result.put("msg", "没有这个用户");
    }

    return result;
  }
}
