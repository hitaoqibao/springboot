package com.example.springbootshiro.config.shiro;

import java.util.List;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.springbootshiro.util.RedisUtil;
import com.example.springbootshiro.util.TokenUtil;
import com.example.springbootshiro.constant.ShiroConstant;

import com.example.springbootshiro.entity.TPermission;
import com.example.springbootshiro.entity.TUser;
import com.example.springbootshiro.exception.CustomException;

import com.example.springbootshiro.service.TPermissionService;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// （1）@RequiresAuthentication ：表示当前Subject已经通过login 进行了身份验证；即Subject. isAuthenticated()返回true
// （2）@RequiresUse：表示当前Subject已经身份验证或者通过记住我登录的
// （3）@RequiresGuest ：表示当前Subject没有身份验证或通过记住我登录过，即是游客身份
// （4）@RequiresRoles：需要相应的角色
// （5）@RequiresPermissions：需要相应的权限

@Slf4j
@Component
public class AuthRealm extends AuthorizingRealm {

  @Autowired
  private TPermissionService tPermissionService;

  // 必须重写，不然会报错
  @Override
  public boolean supports(AuthenticationToken token) {
    return token instanceof AuthToken;
  }

  // 授权
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    log.debug("开始执行授权操作.......");

    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    // 如果身份认证的时候没有传入User对象，这里只能取到userName
    // 也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
    TUser user = (TUser) principalCollection.getPrimaryPrincipal();
    Long userId = user.getId();

    // 获取权限并设置
    List<TPermission> list = tPermissionService.findByUserIdAll(userId);
    if (!list.isEmpty()) {
      list.forEach(o -> {
        authorizationInfo.addStringPermission(o.getRoleId().toString());
      });
    }

    return authorizationInfo;
  }

  // 验证用户
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
      throws AuthenticationException {

    log.info("验证开始。。。");
    String token = (String) authenticationToken.getCredentials();
    TUser user;

    try {
      // 获取token中的userId
      Long userId = TokenUtil.getField(token, "userId", Long.class);
      if (!RedisUtil.hasKey(ShiroConstant.LOGIN_SHIRO_CACHE + userId)) {
        throw new CustomException("redis无该用户,登出或被删除,请重新登陆!");
      }

      user = (TUser) RedisUtil.get(ShiroConstant.LOGIN_SHIRO_CACHE + userId);
      if (!user.getToken().equals(token)) {
        throw new CustomException("token不等错误！请重新登陆");
      }
      // token验证
      TokenUtil.verify(token, user.getUserName(), user.getId());
    } catch (JWTDecodeException e) {
      throw new UnsupportedTokenException("token解密错误");
    } catch (TokenExpiredException e) {
      throw new UnsupportedTokenException("token许可时间过期", e);
    } catch (JWTVerificationException e) {
      throw new UnsupportedTokenException("token解析错误");
    }

    return new SimpleAuthenticationInfo(user, token, this.getName());
  }

  /**
   * 重写 获取缓存名
   */
  @Override
  public String getAuthorizationCacheName() {
    return ShiroConstant.ROLE_SHIRO_CACHE.substring(0, ShiroConstant.ROLE_SHIRO_CACHE.length() - 1);
  }

}
