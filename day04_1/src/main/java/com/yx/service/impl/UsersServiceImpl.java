package com.yx.service.impl;

import com.yx.dao.UsersDao;
import com.yx.entity.Users;
import com.yx.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> list() {
        return usersDao.selectList();
    }
}