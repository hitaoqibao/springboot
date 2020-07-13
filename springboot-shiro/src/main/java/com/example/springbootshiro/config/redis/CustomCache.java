package com.example.springbootshiro.config.redis;

import com.example.springbootshiro.constant.ShiroConstant;
import com.example.springbootshiro.entity.TUser;
import com.example.springbootshiro.util.RedisUtil;
import com.example.springbootshiro.util.TokenUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Collection;
import java.util.Set;

@Slf4j
public class CustomCache<K, V> implements Cache<K, V> {

  /**
   * 缓存的key名称获取为shiro:cache:account
   * 
   * @param key
   */
  private String getKey(K key) {
    String userId;
    if (key instanceof PrincipalCollection) {
      TUser user = (TUser) ((PrincipalCollection) key).getPrimaryPrincipal();
      userId = TokenUtil.getField(user.getToken(), "userId", Long.class).toString();
    } else {
      userId = key.toString();
    }

    return ShiroConstant.CUSTOM_ROLE_SHIRO_CACHE + userId;
  }

  /**
   * 获取缓存
   */
  @Override
  public V get(K key) throws CacheException {
    if (!RedisUtil.hasKey(this.getKey(key))) {
      return null;
    }

    Object o = RedisUtil.get(this.getKey(key));
    V v = (V) o;

    return (V) o;
  }

  /**
   * 保存缓存
   */
  @Override
  public V put(K key, V value) throws CacheException {
    RedisUtil.set(this.getKey(key), value);
    return value;
  }

  /**
   * 移除缓存
   */
  @Override
  public V remove(K key) throws CacheException {
    if (!RedisUtil.hasKey(this.getKey(key))) {
      return null;
    }
    RedisUtil.del(this.getKey(key));
    return null;
  }

  /**
   * 清空所有缓存
   */
  @Override
  public void clear() throws CacheException {

  }

  /**
   * 缓存的个数
   */
  @Override
  public Set<K> keys() {
    return null;
  }

  /**
   * 获取所有的key
   */
  @Override
  public int size() {
    return 0;
  }

  /**
   * 获取所有的value
   */
  @Override
  public Collection<V> values() {
    return null;
  }
}