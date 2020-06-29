package com.example.springbootdemo.result;

/**
 * ResultFactory
 */
public class ResultFactory {
  public static ResultBean buildSuccessResult(Object data, String message) {
    if (message != null && !"".equals(message)) {
      return buidResult(ResultCodeBean.SUCCESS, message, data);
    } else {
      return buidResult(ResultCodeBean.SUCCESS, "成功", data);
    }

  }

  public static ResultBean buildFailResult(String message) {
    return buidResult(ResultCodeBean.FAIL, message, null);
  }

  public static ResultBean buidResult(ResultCodeBean resultCode, String message, Object data) {
    return buidResult(resultCode.code, message, data);
  }

  public static ResultBean buidResult(int resultCode, String message, Object data) {
    return new ResultBean(resultCode, message, data);
  }
}
