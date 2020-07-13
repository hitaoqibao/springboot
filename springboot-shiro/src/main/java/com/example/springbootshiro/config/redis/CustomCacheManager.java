package com.example.springbootshiro.config.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

// 缓存管理器
public class CustomCacheManager implements CacheManager {
  @Override
  public <K, V> Cache<K, V> getCache(String s) throws CacheException {
    return new CustomCache<K, V>();
  }
}