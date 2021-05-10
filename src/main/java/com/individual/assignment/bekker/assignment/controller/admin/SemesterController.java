package com.individual.assignment.bekker.assignment.controller.admin;

import com.individual.assignment.bekker.assignment.dao.DataSourceBeen;
import com.individual.assignment.bekker.assignment.dao.semester.SemesterDaoImpl;
import com.individual.assignment.bekker.assignment.model.Semester;
import com.individual.assignment.bekker.assignment.service.CourseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SemesterController {
    CourseService courseService = new CourseService(
            new SemesterDaoImpl(
                    new DataSourceBeen(
                            "jdbc:mysql://127.0.0.1:3306/individual_assignment_vol03", "root",
                            "", "org.mariadb.jdbc.Driver"
                    )
            )
    );

    @RequestMapping("getAllSubjects")
    public String getAllSubjects() {
        return courseService.getAllCourses();
    }

    @RequestMapping("/addNewSubject")
    public void addNewSubject(@RequestParam String title,
                              @RequestParam int volumeInCredits) {

        Semester semester = new Semester(
                0, title, volumeInCredits
        );

        courseService.addNewSubject(semester);
    }

    @RequestMapping("/updateSubject")
    public void changeSubjectData(@RequestParam long id,
                                  @RequestParam String title,
                                  @RequestParam int volumeInCredits) {

        courseService.changeSubjectData(new Semester(
                id, title, volumeInCredits
        ));
    }

    @RequestMapping("/deleteSubject")
    public void deleteSubject(@RequestParam long id) {
        courseService.deleteSubject(id);
    }
}
