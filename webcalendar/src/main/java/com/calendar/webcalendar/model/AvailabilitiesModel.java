package com.calendar.webcalendar.model;

import java.time.LocalDate;

public class AvailabilitiesModel {
    // les types dependront du front ou database a voir (pour le moment string a cause du front)
    private Long id;
    private String date; //LocalDate
    private String start; // a type for timestamp ?
    private String end; // a type for timestamp ?


    public AvailabilitiesModel() {
        this.id = id;
        this.date = LocalDate.now().toString(); // output format of LocalDate: 2021-01-03
        this.start = "08:00";
        this.end = "08:15";
    }

    public AvailabilitiesModel(Long id, String date, String start, String end) {
        this.id = id;
        this.date = date;
        this.start = start;
        this.end = end;
    }

    //one constructor without because the database will generate one
    public AvailabilitiesModel(String date, String start, String end) {
        this.date = date;
        this.start = start;
        this.end = end;
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

    @Override
    public String toString() {
        return "AvailabilitiesModel{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
