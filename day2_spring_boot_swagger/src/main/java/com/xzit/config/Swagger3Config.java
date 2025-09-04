package com.xzit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger3配置类
 * 用于配置Swagger API文档生成的相关信息
 */
@Configuration
public class Swagger3Config {
    /**
     * 创建Docket对象，配置Swagger的基本信息
     *
     * @return Docket Swagger配置对象
     */
    @Bean
    public Docket apiConfig() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                // 设置通过什么方式定位到需要生成文档的接口.
                // 定位了方法上的ApiOperation
                .apis(RequestHandlerSelectors.basePackage("com.xzit.controller"))
                // 接口URL路径，any表示全部的路径 .regex("/student/*")
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置API的基本信息
     *
     * @return ApiInfo API信息对象
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("学生管理系统 API文档")
                .description("项目描述信息")
                .contact(new Contact("YX", "http://www.itszb.com", "123@qq.com"))
                .version("1.0")
                .build();
    }
}
