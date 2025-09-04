package com.yx.dao;

import com.yx.entity.Users;
import java.util.List;

public interface UsersDao {
    List<Users> selectList();
}