package com.example.wiki.controller;

import com.example.wiki.domain.Test;
import com.example.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Value("${test.hello:TEST}")
    public String testHello;

    @Resource
    private TestService testService;


    @GetMapping("/hello")
    public String hello(){
        return "Hello World"+testHello;
    }

    @GetMapping("/test/list")
    public List<Test> list(){
        return testService.list();
    }
}
