package com.example.reservationback.repository;

import com.example.reservationback.model.Reservation;
import com.example.reservationback.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByTimeFromBetweenAndTableEquals(@Param("begin") Calendar begin, @Param("end") Calendar end, @Param("table") Table table);
}

