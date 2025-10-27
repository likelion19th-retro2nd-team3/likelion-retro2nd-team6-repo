package com.members.정다희.labs.practice_251014.service;

import com.members.정다희.labs.practice_251014.domain.User;
import com.members.정다희.labs.practice_251014.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void joinUser(User user) {
        userDao.addUser(user);
    }
}
