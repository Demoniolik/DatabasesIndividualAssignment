package com.individual.assignment.bekker.assignment.dao.user;

import com.individual.assignment.bekker.assignment.dao.DAO;
import com.individual.assignment.bekker.assignment.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends DAO<User> {
    List<User> getAllUsers() throws SQLException;
    User getUserById();
    User getUserByCredentials(String login, String password);

    boolean isLoginAlreadyExist(String login);
}
