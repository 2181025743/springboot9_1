package com.yx;

import com.yx.service.UsersService;
import com.yx.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = D4SpringbootJUnitApplication.class)
public class UserServiceTest {

    @Autowired
    private UsersService usersService;

    @Test
    public void testList() {
        List<Users> list = usersService.list();
        System.out.println(list);
    }
}