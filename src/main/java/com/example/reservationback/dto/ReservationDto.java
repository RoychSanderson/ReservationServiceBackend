package com.example.reservationback.dto;

import com.example.reservationback.model.Person;

import java.util.Calendar;

public class ReservationDto {
    private Integer table_ID;

    private String status;

    private Calendar timeFrom;

    private Calendar timeUntil;

    private String comment;

    private Integer seats;

    private Person person;

    public Integer getTable_ID() {
        return table_ID;
    }

    public void setTable_ID(Integer table_ID) {
        this.table_ID = table_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Calendar getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Calendar timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Calendar getTimeUntil() {
        return timeUntil;
    }

    public void setTimeUntil(Calendar timeUntil) {
        this.timeUntil = timeUntil;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
