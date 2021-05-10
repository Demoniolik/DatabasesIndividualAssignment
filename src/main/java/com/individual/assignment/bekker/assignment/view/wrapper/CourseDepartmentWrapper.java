package com.individual.assignment.bekker.assignment.view.wrapper;

public class CourseDepartmentWrapper {
    private String departmentName;
    private String courseTitle;

    public CourseDepartmentWrapper(String departmentName, String courseTitle) {
        this.departmentName = departmentName;
        this.courseTitle = courseTitle;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}
