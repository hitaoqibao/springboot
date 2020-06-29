package com.example.springbootmybatisplus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfiguration前后端跨域
 */
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") // 匹配了所有的URL
        .allowedHeaders("*") // 允许跨域请求包含任意的头信息
        .allowedMethods("*") // 允许外域发起请求任意HTTP Method
        .allowedOrigins("*"); // 允许所有的外域发起跨域请求
  }

}