package com.individual.assignment.bekker.assignment.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.individual.assignment.bekker.assignment.dao.DataSourceBeen;
import com.individual.assignment.bekker.assignment.dao.semester.SemesterDaoImpl;
import com.individual.assignment.bekker.assignment.model.Lecturer;
import com.individual.assignment.bekker.assignment.service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService = new CourseService(
            SemesterDaoImpl.getInstance(
                    new DataSourceBeen(
                            "jdbc:mysql://127.0.0.1:3306/individual_assignment_vol03", "customer",
                            "customer_password", "org.mariadb.jdbc.Driver"
                    )
            )
    );

    @RequestMapping("/getCoursesForEachLecturerWithWorkLoad")
    public String getCoursesForLecturersWithWorkLoad() {
        Type listOfTestObject = new TypeToken<List<Lecturer>>(){}.getType();
        Gson gson = new Gson();
        String courses = gson.toJson(courseService
                .getCourseForEachLecturerWithWorkload(), listOfTestObject);
        return courses;
    }

    @RequestMapping("/getListOfCoursesForEachDepartment")
    public String getListOfCoursesForEachDepartment() {
        Type listOfTestObject = new TypeToken<List<Lecturer>>(){}.getType();
        Gson gson = new Gson();
        String courses = gson.toJson(courseService
                .getCoursesForEachDepartment(), listOfTestObject);
        return courses;
    }
}
