package com.example.reservationback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@javax.persistence.Table(name = "reservations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DynamicUpdate
@DynamicInsert
public class Reservation implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Table table;
    @Column(name = "status")
    private String status;
    @Column(name = "time_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar timeFrom;
    @Column(name = "time_until")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar timeUntil;
    @Column(name = "seats")
    private Integer seats;
    @Column(name = "comment")
    private String comment;
    @Embedded
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String info) {
        this.comment = info;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @JsonIgnore
    public Table getTable() {
        return table;
    }

    @JsonIgnore
    public void setTable(Table table) {
        this.table = table;
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

    public Integer getTable_ID(){
        return table.getId();
    }

}
