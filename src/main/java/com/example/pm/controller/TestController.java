package com.example.pm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @RequestMapping("/access")
    public void testAccess(){
        System.out.println("访问成功！");
    }
}
