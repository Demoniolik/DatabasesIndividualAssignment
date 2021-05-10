package com.individual.assignment.bekker.assignment.dao.lecturer;

import com.individual.assignment.bekker.assignment.dao.DAO;
import com.individual.assignment.bekker.assignment.model.Lecturer;
import com.individual.assignment.bekker.assignment.view.wrapper.LecturerForEachCourseWrapper;

import java.util.List;

public interface LecturerDao extends DAO<Lecturer> {
    List<LecturerForEachCourseWrapper> getListOfLecturersForEachCourse();
}
