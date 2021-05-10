package com.individual.assignment.bekker.assignment.dao.semester;

import com.individual.assignment.bekker.assignment.dao.DAO;
import com.individual.assignment.bekker.assignment.model.Semester;
import com.individual.assignment.bekker.assignment.view.wrapper.CourseDepartmentWrapper;
import com.individual.assignment.bekker.assignment.view.wrapper.CoursesForAllLecturersWithWorkLoadWrapper;

import java.util.List;

public interface SemesterDao extends DAO<Semester> {
    List<CoursesForAllLecturersWithWorkLoadWrapper>
    getCoursesForEachLecturerWithWorkload();

    List<CourseDepartmentWrapper> getCoursesForEachDepartment();

    void changeSemesterData(Semester semester);

    void delete(long id);
}
