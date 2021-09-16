package com.example.pm.task;

import com.example.pm.constant.ChatMessageCacheKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class ChatMessageClearTask {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Scheduled(fixedDelay = 2 * 1000)
    public void job(){
        System.out.println("excute....clear");
        redisTemplate.opsForList().leftPop(ChatMessageCacheKey.CHATMESSAGECACHEKAY);
    }
}
