package com.xzit.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@Tag(name = "学生管理相关接口")
public class StudentController {

    @GetMapping("/hello")
    @Operation(summary = "获取 hello 消息")
    public String hello() {
        return "Hello Swagger!";
    }
}