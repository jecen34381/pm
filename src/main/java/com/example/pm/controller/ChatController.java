package com.example.pm.controller;

import com.example.pm.bean.ChatMessage;
import com.example.pm.constant.ChatMessageCacheKey;
import com.example.pm.response.ChatMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/push/chat/message")
    public void pushChatMessage(@RequestBody ChatMessage chatMessage){
        //如果超过十条信息就把最老的一条给删除掉
        long size = redisTemplate.opsForList().size(ChatMessageCacheKey.CHATMESSAGECACHEKAY);
        if (size >= 10){
            redisTemplate.opsForList().rightPop(ChatMessageCacheKey.CHATMESSAGECACHEKAY);
        }
        if (chatMessage != null && chatMessage.getMessage() != null) {
            redisTemplate.opsForList().leftPush(ChatMessageCacheKey.CHATMESSAGECACHEKAY, chatMessage.getMessage());
        }
    }
    @RequestMapping("/message/pop")
    public ChatMessageResponse chatMessagePop(@RequestBody ChatMessage chatMessage){
        //List<String> messages = redisTemplate.opsForList().range(ChatMessageCacheKey.CHATMESSAGECACHEKAY, chatMessage.getStart(), chatMessage.getEnd());
        long size = redisTemplate.opsForList().size(ChatMessageCacheKey.CHATMESSAGECACHEKAY);
        List<String> messages = redisTemplate.opsForList().range(ChatMessageCacheKey.CHATMESSAGECACHEKAY, chatMessage.getStart(), size);
        ChatMessageResponse response = new ChatMessageResponse();
        response.setMessages(messages);
        return response;
    }
}
