package com.example.pm.controller;

import com.example.pm.bean.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/task")
@RestController
public class TaskController extends BaseController<TaskController> {

    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @RequestMapping("/backlog/list")
    public String backlogList(){
        logger.info("待处理问题查询。");
        //redisTemplate.opsForList().leftPush("CHAT", "nihao");
        return
                "1:进入特别程序，定时器计时问题。\n" +
                "2:材料补齐补正不能同步问题。\n" +
                "3:一张蓝图国家不能访问问题。\n" +
                "待定问题。。。\n";
    }

}
