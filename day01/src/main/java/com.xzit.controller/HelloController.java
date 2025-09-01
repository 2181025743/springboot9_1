package com.xzit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // => 相当于 @Controller + @ResponseBody
public class HelloController {

    @GetMapping("/index")
    public String index() {
        return "Hello Spring Boot";
    }
}