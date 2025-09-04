package yx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${sysUser}")
    private String sysUser;
    @Value("${age}")
    private int age;
    @Value("${money}")
    private double money;
    @Value("${birth}")
    private Date birth;

    @GetMapping
    public Object show() {
        System.out.println(sysUser + "\t" + age + "\t" + money);
        System.out.println(birth);
        return "ok";
    }
}