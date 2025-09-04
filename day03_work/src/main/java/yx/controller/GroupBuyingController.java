package yx.controller;

import yx.service.GroupBuyingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/groupbuying")
public class GroupBuyingController {

    @Autowired
    private GroupBuyingService groupBuyingService;

    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${server.port}")
    private String port;

    @GetMapping("/buy")
    public Map<String, Object> buy() {
        Map<String, Object> result = new HashMap<>();
        result.put("当前环境", profile);
        result.put("端口号", port);
        result.put("团购服务", groupBuyingService.buy());
        return result;
    }
}