package com.individual.assignment.bekker.assignment.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.individual.assignment.bekker.assignment.dao.semester.SemesterDao;
import com.individual.assignment.bekker.assignment.model.Semester;
import com.individual.assignment.bekker.assignment.view.wrapper.CourseDepartmentWrapper;
import com.individual.assignment.bekker.assignment.view.wrapper.CoursesForAllLecturersWithWorkLoadWrapper;

import java.lang.reflect.Type;
import java.util.List;

public class CourseService {
    private SemesterDao semesterDao;

    public CourseService(SemesterDao semesterDao) {
        this.semesterDao = semesterDao;
    }


    public List<CoursesForAllLecturersWithWorkLoadWrapper>
    getCourseForEachLecturerWithWorkload() {
        return semesterDao.getCoursesForEachLecturerWithWorkload();
    }

    public List<CourseDepartmentWrapper> getCoursesForEachDepartment() {
        return semesterDao.getCoursesForEachDepartment();
    }

    public String getAllCourses() {
        List<Semester> list = semesterDao.getAll();
        Type type = new TypeToken<List<Semester>>(){}.getType();
        Gson gson = new Gson();
        return gson.toJson(list, type);
    }

    public void addNewSubject(Semester semester) {
        semesterDao.save(semester);
    }

    public void changeSubjectData(Semester semester) {
        semesterDao.changeSemesterData(semester);
    }

    public void deleteSubject(long id) {
        semesterDao.delete(id);
    }
}
