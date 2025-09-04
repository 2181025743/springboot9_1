package yx.service.impl;

import yx.service.GroupBuyingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class MeituanService implements GroupBuyingService {
    @Override
    public String buy() {
        return "正在使用【美团优选】进行社区团购";
    }
}