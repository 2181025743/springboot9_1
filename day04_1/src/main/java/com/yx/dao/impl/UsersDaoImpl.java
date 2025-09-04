package com.yx.dao.impl;

import com.yx.dao.UsersDao;
import com.yx.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {
    @Override
    public List<Users> selectList() {
        List<Users> list = new ArrayList<>();
        list.add(new Users(1, "张三", 20));
        list.add(new Users(2, "李四", 22));
        list.add(new Users(3, "王五", 24));
        list.add(new Users(4, "赵六", 26));
        return list;
    }
}