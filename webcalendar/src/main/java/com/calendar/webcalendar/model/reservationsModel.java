package com.calendar.webcalendar.model;

public class reservationsModel {

    private Long id;
    private String date;
    private String start;
    private String end;
    private String title;
    private String email;

    public reservationsModel() {
        this.id = id;
    }

    public reservationsModel(Long id, String date, String start, String end, String title, String email) {
        this.id = id;
        this.date = date;
        this.start = start;
        this.end = end;
        this.title = title;
        this.email = email;
    }

    //one constructor without because the database will generate one
    public reservationsModel(String date, String start, String end, String title, String email) {
        this.date = date;
        this.start = start;
        this.end = end;
        this.title = title;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "reservationsModel{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
