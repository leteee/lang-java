package com.example.springboot.controller;

import com.example.springboot.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Caching(
            put = {
                    @CachePut(cacheNames = "demo")
            }
    )
    @PostMapping()
    public R set(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return R.success();
    }

    @Caching(
            cacheable = {
                    @Cacheable(cacheNames = "demo")
            }
    )
    @GetMapping()
    public R get(@RequestParam(value = "key") String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return R.success(value);
    }

    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "demo")
            }
    )
    @DeleteMapping()
    public R delete(@RequestParam(value = "key") String key) {
        redisTemplate.delete(key);
        return R.success();
    }
}
