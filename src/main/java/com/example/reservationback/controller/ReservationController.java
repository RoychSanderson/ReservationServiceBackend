package com.example.reservationback.controller;

import com.example.reservationback.dto.ReservationDto;
import com.example.reservationback.model.Reservation;
import com.example.reservationback.model.Table;
import com.example.reservationback.service.ReservationService;
import com.example.reservationback.service.TableService;
import com.example.reservationback.utils.MappingUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ReservationController {
    private final ReservationService reservationService;
    private final TableService tableService;

    @Autowired
    public ReservationController(ReservationService reservationService, TableService tableService){
        this.reservationService = reservationService;
        this.tableService = tableService;
    }

    @PutMapping(value = "/reservations/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody ReservationDto dto){

        Reservation reservation = reservationService.read(id);
        Integer olId = reservation.getTable_ID();
        Table olTable = tableService.read(olId);
        Table table = tableService.read(dto.getTable_ID());
        MappingUtils.mapToUpdatedReservation(dto, reservation, table);

        tableService.update(table, table.getId());
        tableService.update(olTable, olId);
        final boolean updated = reservationService.update(reservation, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping(value = "/reservations")
    public ResponseEntity<?> create(@RequestBody ReservationDto dto){

        Table table = tableService.read(dto.getTable_ID());
        Reservation reservation = MappingUtils.mapToReservation(dto, table);
        reservationService.create(reservation);
        tableService.update(table, table.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/reservations/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = reservationService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/reservations")
    public ResponseEntity<List<Reservation>> read() {
        final List<Reservation> reservations = reservationService.readAll();
        return reservations != null && !reservations.isEmpty()
                ? new ResponseEntity<>(reservations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/reservations/{id}")
    public ResponseEntity<Reservation> read(@PathVariable(name = "id") Integer id) {
        final Reservation reservation = reservationService.read(id);
        return reservation != null
                ? new ResponseEntity<>(reservation, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
