package com.individual.assignment.bekker.assignment.applicationcontext;

import com.individual.assignment.bekker.assignment.dao.DataSourceBeen;
import com.individual.assignment.bekker.assignment.dao.user.UserDaoImpl;
import com.individual.assignment.bekker.assignment.service.UserService;

public class ApplicationContext {
    private UserService userService;
    private String url;
    private String user;
    private String password;
    private String driverName;

    public ApplicationContext(String url, String user, String password, String driverName) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.driverName = driverName;
        init();
    }

    public void init() {
        userService = new UserService(
                UserDaoImpl.getInstance(new DataSourceBeen(
                        url, user, password, driverName
                ))
        );
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }
}
