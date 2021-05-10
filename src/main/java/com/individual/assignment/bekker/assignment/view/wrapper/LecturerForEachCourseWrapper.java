package com.individual.assignment.bekker.assignment.view.wrapper;

public class LecturerForEachCourseWrapper {
    private String courseName;
    private String lecturerFirstName;
    private String lecturerLastName;

    public LecturerForEachCourseWrapper() {}

    public LecturerForEachCourseWrapper(String courseName,
                                        String lecturerFirstName,
                                        String lecturerLastName) {
        this.courseName = courseName;
        this.lecturerFirstName = lecturerFirstName;
        this.lecturerLastName = lecturerLastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLecturerFirstName() {
        return lecturerFirstName;
    }

    public void setLecturerFirstName(String lecturerFirstName) {
        this.lecturerFirstName = lecturerFirstName;
    }

    public String getLecturerLastName() {
        return lecturerLastName;
    }

    public void setLecturerLastName(String lecturerLastName) {
        this.lecturerLastName = lecturerLastName;
    }
}
