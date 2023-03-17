package com.example.reservationback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@javax.persistence.Table(name = "restaurants")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DynamicUpdate
@DynamicInsert
public class Restaurant implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "url")
    private String url;
    @Column(name = "address")
    private String address;
    @Column(name = "description")
    private String description;
    @Column(name = "working_hours_from")
    private LocalTime workingHoursFrom;
    @Column(name = "working_hours_until")
    private LocalTime workingHoursUntil;
    @Column(name = "default_reservation_time")
    private LocalTime defaultReservationTime;
    @OneToMany(targetEntity = Table.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurants_id")
    @JsonIgnore
    private List<Table> tables;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public LocalTime getWorkingHoursFrom() {
        return workingHoursFrom;
    }

    public void setWorkingHoursFrom(LocalTime workingHoursFrom) {
        this.workingHoursFrom = workingHoursFrom;
    }

    public LocalTime getWorkingHoursUntil() {
        return workingHoursUntil;
    }

    public void setWorkingHoursUntil(LocalTime workingHoursUntil) {
        this.workingHoursUntil = workingHoursUntil;
    }

    public LocalTime getDefaultReservationTime() {
        return defaultReservationTime;
    }

    public void setDefaultReservationTime(LocalTime defaultReservationTime) {
        this.defaultReservationTime = defaultReservationTime;
    }
}
