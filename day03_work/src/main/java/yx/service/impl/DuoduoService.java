package yx.service.impl;

import yx.service.GroupBuyingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class DuoduoService implements GroupBuyingService {
    @Override
    public String buy() {
        return "正在使用【多多买菜】进行社区团购";
    }
}