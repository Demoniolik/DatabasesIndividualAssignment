package com.individual.assignment.bekker.assignment.model;

public class Lecturer {
    private long id;
    private String firstName;
    private String secondName;
    private String sex;
    private String telephoneNumber;
    private String email;
    private String cabinetNumber;
    private long departmentId;

    public Lecturer() {}

    public Lecturer(long id, String firstName, String secondName,
                    String sex, String telephoneNumber, String email,
                    String cabinetNumber, long departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.sex = sex;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.cabinetNumber = cabinetNumber;
        this.departmentId = departmentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }
}
