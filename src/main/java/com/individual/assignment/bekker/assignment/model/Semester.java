package com.individual.assignment.bekker.assignment.model;

public class Semester {
    private long id;
    private String title;
    private int volumeInCredits;

    public Semester(long id, String title, int volumeInCredits) {
        this.id = id;
        this.title = title;
        this.volumeInCredits = volumeInCredits;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVolumeInCredits() {
        return volumeInCredits;
    }

    public void setVolumeInCredits(int volumeInCredits) {
        this.volumeInCredits = volumeInCredits;
    }
}
