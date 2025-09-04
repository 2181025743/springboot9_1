package com.xzit.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// bean.xml   applicationContext.xml
//<bean id="" class="">
@Configuration
public class Swagger3Config {
    @Bean
    public OpenAPI apiConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("十指波项目")
                        .description("项目描述信息")
                        .version("1.0")
                        .contact(new Contact()
                                .name("史老师")
                                .url("http://www.itszb.com")
                                .email("234234324@qq.com")));
    }
}
