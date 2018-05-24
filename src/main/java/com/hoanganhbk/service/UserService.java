package com.hoanganhbk.service;

import com.hoanganhbk.daoimpl.UserDaoImpl;
import com.hoanganhbk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDaoImpl userDao;

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public boolean isExist(String username) {
        return userDao.isExist(username);
    }

    public int userRegisterValidate(String username, String password){
        return userDao.userRegisterValidate(username, password);
    }

    public List<User> getListUsers() {
        return userDao.getListUsers();
    }

    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
