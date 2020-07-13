package com.example.springbootshiro.exception;

import org.apache.shiro.authc.AuthenticationException;

public class CustomException extends AuthenticationException {

  /**
  *
  */
  private static final long serialVersionUID = 1L;

  public CustomException() {
  }

  public CustomException(String message) {
    super(message);
  }

}