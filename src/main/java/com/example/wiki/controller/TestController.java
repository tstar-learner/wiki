package com.example.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${test.hello:TEST}")
    public String testHello;


    @GetMapping("/hello")
    public String hello(){
        return "Hello World"+testHello;
    }
}
