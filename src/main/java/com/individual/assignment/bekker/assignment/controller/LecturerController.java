package com.individual.assignment.bekker.assignment.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.individual.assignment.bekker.assignment.dao.DataSourceBeen;
import com.individual.assignment.bekker.assignment.dao.lecturer.LecturerDaoImpl;
import com.individual.assignment.bekker.assignment.model.Lecturer;
import com.individual.assignment.bekker.assignment.service.LecturerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
public class LecturerController {
    private LecturerService lecturerService = new LecturerService(
            LecturerDaoImpl.getInstance(
                    new DataSourceBeen(
                            "jdbc:mysql://127.0.0.1:3306/individual_assignment_vol03", "customer",
                            "customer_password", "org.mariadb.jdbc.Driver"
                    )
            )
    );

    @RequestMapping("/getAllLecturers")
    public String getAllLecturersForAllCourses() {
        Type listOfTestObject = new TypeToken<List<Lecturer>>(){}.getType();
        Gson gson = new Gson();
        String lecturers = gson.toJson(lecturerService
                .getAllLecturers(), listOfTestObject);
        return lecturers;
    }

    @RequestMapping("/showListOfLecturersForEachCourse")
    public String getListOfLecturersForEachCourse() {
        Type listOfTestObject = new TypeToken<List<Lecturer>>(){}.getType();
        Gson gson = new Gson();
        String lecturers = gson.toJson(lecturerService
                .getLecturerForEachCourse(), listOfTestObject);
        return lecturers;
    }
}
