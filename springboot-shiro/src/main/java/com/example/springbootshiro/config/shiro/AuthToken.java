package com.example.springbootshiro.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class AuthToken implements AuthenticationToken {

  private static final long serialVersionUID = 1L;
  private String token;

  public AuthToken() {
  }

  public AuthToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  @Override
  public Object getPrincipal() {
    return token;
  }

  @Override
  public Object getCredentials() {
    return token;
  }
}
