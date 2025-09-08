package yx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("yx.mapper")
public class Applications {
    public static void main(String[] args) {
        SpringApplication.run(Applications.class, args);
    }
}