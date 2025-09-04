package com.xzit.controller;

import com.xzit.model.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Value("${age}")
    private int age;
    @GetMapping("/uservalue")
    public Object show(){
        return age;
    }
}
