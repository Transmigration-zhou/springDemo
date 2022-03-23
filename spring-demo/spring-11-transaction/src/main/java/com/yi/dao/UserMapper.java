package com.yi.dao;

import com.yi.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();

    //增加一个用户
    int addUser(User user);

    //删除一个用户
    int deleteUser(int id);
}
