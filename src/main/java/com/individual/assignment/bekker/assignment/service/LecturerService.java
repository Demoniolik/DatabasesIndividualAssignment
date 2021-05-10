package com.individual.assignment.bekker.assignment.service;

import com.individual.assignment.bekker.assignment.dao.lecturer.LecturerDao;
import com.individual.assignment.bekker.assignment.model.Lecturer;
import com.individual.assignment.bekker.assignment.view.wrapper.LecturerForEachCourseWrapper;

import java.util.List;

public class LecturerService {
    LecturerDao lecturerDao;

    public LecturerService(LecturerDao lecturerDao) {
        this.lecturerDao = lecturerDao;
    }

    public List<Lecturer> getAllLecturers() {
        return lecturerDao.getAll();
    }

    public List<LecturerForEachCourseWrapper> getLecturerForEachCourse() {
        return lecturerDao.getListOfLecturersForEachCourse();
    }
}
