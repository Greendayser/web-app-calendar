package com.calendar.webcalendar.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class ReservationsModel {

    @Id
    @SequenceGenerator(
            name = "reservationsModel_sequence",
            sequenceName = "reservationsModel_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservationsModel_sequence"
    )

    private Long id;
    private LocalDate date;
    @Column(name = "valueStart")
    private String start;
    @Column(name = "valueEnd")
    private String end;
    @Column(name = "valueTitle")
    private String title;
    @Column(name = "valueEmail")
    private String email;

    public ReservationsModel() {
        this.id = id;
        this.date = LocalDate.now();
        this.start = "08:00";
        this.end = "08:15";
        this.email = "john.doe@gmail.com";
    }

    public ReservationsModel(Long id, LocalDate date, String start, String end, String title, String email) {
        this.id = id;
        this.date = date;
        this.start = start;
        this.end = end;
        this.title = title;
        this.email = email;
    }

    //one constructor without because the database will generate one
    public ReservationsModel(LocalDate date, String start, String end, String title, String email) {
        this.date = date;
        this.start = start;
        this.end = end;
        this.title = title;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
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
