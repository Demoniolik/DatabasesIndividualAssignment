package com.individual.assignment.bekker.assignment.dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceBeen {
    private String url;
    private String user;
    private String password;
    private String driverClass;

    public DataSourceBeen(String url, String user, String password, String driverClass) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.driverClass = driverClass;
    }

    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClass);
        return dataSource;
    }
}
