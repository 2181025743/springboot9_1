package yx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("yx.mapper") // 👈 必须加上，否则 Mapper 无法注入
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}