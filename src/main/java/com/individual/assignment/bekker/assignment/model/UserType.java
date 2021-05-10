package com.individual.assignment.bekker.assignment.model;

public enum UserType {
    ADMIN("admin"),
    CUSTOMER("customer");

    String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}
