package com.gara.springbootshiro.cache;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.Collection;
import java.util.Set;

public class ShiroRedisCacheManager implements CacheManager, Destroyable {

    private RedisCacheManager cacheManager;

    public RedisCacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(RedisCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    //为了个性化配置redis存储时的key，我们选择了加前缀的方式，所以写了一个带名字及redis操作的构造函数的Cache类
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        if (name == null) {
            return null;
        }
        return new ShiroRedisCache<K, V>(name, getCacheManager());
    }

    @Override
    public void destroy() throws Exception {
        cacheManager = null;
    }

    /**
     * <p> 自定义缓存 将数据存入到redis中 </p>
     *
     * @param <K>
     * @param <V>
     * @author xxx
     * @date 2018年2月1日
     * @time 22:32:11
     */
    @Slf4j
    static class ShiroRedisCache<K, V> implements org.apache.shiro.cache.Cache<K, V> {
        private RedisCacheManager cacheManager;
        private org.springframework.cache.Cache cache;

        //    private RedisCache cache2;
        public ShiroRedisCache(String name, RedisCacheManager cacheManager) {
            if (name == null || cacheManager == null) {
                throw new IllegalArgumentException("cacheManager or CacheName cannot be null.");
            }
            this.cacheManager = cacheManager;
            //这里首先是从父类中获取这个cache,如果没有会创建一个redisCache,初始化这个redisCache的时候
            //会设置它的过期时间如果没有配置过这个缓存的，那么默认的缓存时间是为0的，如果配置了，就会把配置的时间赋予给这个RedisCache
            //如果从缓存的过期时间为0，就表示这个RedisCache不存在了，这个redisCache实现了spring中的cache
            this.cache = cacheManager.getCache(name);
        }

        @Override
        public V get(K key) throws CacheException {
            log.info("从缓存中获取key为{}的缓存信息", key);
            if (key == null) {
                return null;
            }
            org.springframework.cache.Cache.ValueWrapper valueWrapper = cache.get(key);
            if (valueWrapper == null) {
                return null;
            }
            return (V) valueWrapper.get();
        }

        @Override
        public V put(K key, V value) throws CacheException {
            log.info("创建新的缓存，信息为：{}={}", key, value);
            cache.put(key, value);
            return get(key);
        }

        @Override
        public V remove(K key) throws CacheException {
            log.info("干掉key为{}的缓存", key);
            V v = get(key);
            cache.evict(key);//干掉这个名字为key的缓存
            return v;
        }

        @Override
        public void clear() throws CacheException {
            log.info("清空所有的缓存");
            cache.clear();
        }

        @Override
        public int size() {
            return cacheManager.getCacheNames().size();
        }

        /**
         * 获取缓存中所的key值
         */
        @Override
        public Set<K> keys() {
            return (Set<K>) cacheManager.getCacheNames();
        }

        /**
         * 获取缓存中所有的values值
         */
        @Override
        public Collection<V> values() {
            return (Collection<V>) cache.get(cacheManager.getCacheNames()).get();
        }

        @Override
        public String toString() {
            return "ShiroSpringCache [cache=" + cache + "]";
        }
    }
}
