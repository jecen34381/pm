package com.example.pm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;

@Configuration
public class RedisConfig {
    @Autowired
    private RedisTemplate redisTemplate;

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    private void initRedisTemplate(){
        RedisSerializer redisSerializer = redisTemplate.getStringSerializer();
        //对RedisTemplate的默认序列化进行修改
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
    }

}
