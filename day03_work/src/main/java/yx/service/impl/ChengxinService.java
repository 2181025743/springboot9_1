package yx.service.impl;

import yx.service.GroupBuyingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class ChengxinService implements GroupBuyingService {
    @Override
    public String buy() {
        return "正在使用【橙心优选】进行社区团购";
    }
}