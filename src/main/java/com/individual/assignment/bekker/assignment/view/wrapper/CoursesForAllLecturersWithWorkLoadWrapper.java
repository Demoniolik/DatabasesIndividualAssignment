package com.individual.assignment.bekker.assignment.view.wrapper;

public class CoursesForAllLecturersWithWorkLoadWrapper {
    private String firstName;
    private String secondName;
    private String title;
    private String activityName;

    public CoursesForAllLecturersWithWorkLoadWrapper(String firstName, String secondName,
                                                     String title, String activityName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.title = title;
        this.activityName = activityName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
