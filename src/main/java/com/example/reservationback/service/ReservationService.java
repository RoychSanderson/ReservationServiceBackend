package com.example.reservationback.service;

import com.example.reservationback.model.Reservation;
import com.example.reservationback.model.Table;

import java.util.Calendar;
import java.util.List;

public interface ReservationService {
    void create(Reservation reservation);

    List<Reservation> readAll();

    Reservation read(Integer id);

    boolean update(Reservation reservation, Integer id);

    boolean delete(int id);

    List<Reservation> findByDay(Calendar day, Table table);
}
