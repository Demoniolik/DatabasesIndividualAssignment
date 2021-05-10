package com.individual.assignment.bekker.assignment.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.individual.assignment.bekker.assignment.dao.department.DepartmentDao;
import com.individual.assignment.bekker.assignment.model.Department;
import com.individual.assignment.bekker.assignment.model.Semester;

import java.lang.reflect.Type;
import java.util.List;

public class DepartmentService {
    private DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public String getAllDepartments() {
        List<Department> list = departmentDao.getAll();
        Type type = new TypeToken<List<Department>>(){}.getType();
        Gson gson = new Gson();
        return gson.toJson(list, type);
    }
}
