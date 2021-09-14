package com.example.pm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/task")
@RestController
public class TaskController {

    @RequestMapping("/backlog/list")
    public String backlogList(){
        return "<html>\n" +
                "<body>\n" +
                "<p>1:进入特别程序，定时器计时问题。</p>\n" +
                "<p>2:材料补齐补正不能同步问题。</p>\n" +
                "<p>3:一张蓝图国家不能访问问题。</p>\n" +
                "<p>待定问题。。。</p>\n" +
                "</body>\n" +
                "</html>";
    }
}
