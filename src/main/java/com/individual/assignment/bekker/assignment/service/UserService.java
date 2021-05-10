package com.individual.assignment.bekker.assignment.service;

import com.individual.assignment.bekker.assignment.dao.user.UserDao;
import com.individual.assignment.bekker.assignment.model.User;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean isLoginAlreadyExist(String login) {
        return userDao.isLoginAlreadyExist(login);
    }

    public String registerUser(User user) {
        if (userDao.isLoginAlreadyExist(user.getLogin())) {
            return "login.html";
        }

        userDao.save(user);

        return "mainPage.html";
    }

    public User getUserByCredentials(String login, String password) {
        return userDao.getUserByCredentials(login, password);
    }
}
