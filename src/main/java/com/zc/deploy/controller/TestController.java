package com.zc.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Kent Lee
 * 2018/8/18
 */
@RestController
public class TestController {
    @RequestMapping("/")
    public String index(){
        System.out.println("AAAAAA");
        return "index.html";
    }
}
