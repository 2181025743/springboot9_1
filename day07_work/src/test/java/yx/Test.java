package yx;

import org.springframework.boot.test.context.SpringBootTest;
import yx.entity.StatusEnum;
import yx.entity.User;

import java.util.List;

@SpringBootTest(classes = Applications.class) // 明确指定配置类
public class Test {
    @org.junit.jupiter.api.Test
    void test() {
        User name1 = new User().setName("name1").setPassword("123456").setStatus(StatusEnum.ACTIVE);
        name1.insert();

        List<User> users = new User().selectAll();

        System.out.println(users);
    }
}
