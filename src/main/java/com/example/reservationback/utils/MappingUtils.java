package com.example.reservationback.utils;

import com.example.reservationback.dto.ReservationDto;
import com.example.reservationback.dto.TableDto;
import com.example.reservationback.model.Reservation;
import com.example.reservationback.model.Restaurant;
import com.example.reservationback.model.Table;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    public static void mapToUpdatedReservation(ReservationDto dto, Reservation reservation, Table table) {
        reservation.setPerson(dto.getPerson());
        reservation.setTimeUntil(dto.getTimeUntil());
        reservation.setTimeFrom(dto.getTimeFrom());
        if (dto.getStatus() != null) reservation.setStatus(dto.getStatus());
        if (dto.getComment() != null) reservation.setComment(dto.getComment());
        reservation.setTable(table);
        table.addReservation(reservation);
    }

    public static Reservation mapToReservation(ReservationDto dto, Table table) {
        Reservation reservation = new Reservation();
        reservation.setPerson(dto.getPerson());
        reservation.setTimeUntil(dto.getTimeUntil());
        reservation.setTimeFrom(dto.getTimeFrom());
        if (dto.getStatus() != null) reservation.setStatus(dto.getStatus());
        if (dto.getComment() != null) reservation.setComment(dto.getComment());
        reservation.setTable(table);
        table.addReservation(reservation);
        return reservation;
    }

    public static Table mapToTable(TableDto dto, Restaurant restaurant) {
        Table table = new Table();
        table.setName(dto.getName());
        table.setSeats(dto.getSeats());
        table.setRestaurant(restaurant);
        return table;
    }

    public static Table mapToTableUpdate(TableDto dto, Table table, Restaurant restaurant) {
        table.setName(dto.getName());
        table.setSeats(dto.getSeats());
        table.setRestaurant(restaurant);
        return table;
    }
}
