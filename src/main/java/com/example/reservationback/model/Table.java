package com.example.reservationback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@javax.persistence.Table(name = "tables")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DynamicUpdate
@DynamicInsert
public class Table implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;
    @Column(name = "name")
    private String name;
    @Column(name = "capacity")
    private Integer seats;
    @OneToMany(targetEntity = Reservation.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id")
    private List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public Restaurant getRestaurant() {
        return restaurant;
    }

    @JsonIgnore
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer capacity) {
        this.seats = capacity;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
            this.reservations = reservations;
    }

    public void addReservation(Reservation reservation){
        if (this.reservations == null){
            this.reservations = new ArrayList<>();
        }
        reservation.setTable(this);
        reservations.add(reservation);
    }
}
