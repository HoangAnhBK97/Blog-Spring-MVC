package com.hoanganhbk.dao;

import com.hoanganhbk.entity.User;

import java.util.List;

public interface UserDAO {
    boolean addUser(User user);
    boolean isExist(String username);
    int userRegisterValidate(String username, String password);
    List<User> getListUsers();
    User findUserByUsername(String username);
}
