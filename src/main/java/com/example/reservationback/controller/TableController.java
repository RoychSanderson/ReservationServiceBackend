package com.example.reservationback.controller;

import com.example.reservationback.dto.TableDto;
import com.example.reservationback.model.Reservation;
import com.example.reservationback.model.Restaurant;
import com.example.reservationback.model.Table;
import com.example.reservationback.service.ReservationService;
import com.example.reservationback.service.RestaurantService;
import com.example.reservationback.service.TableService;
import com.example.reservationback.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@RestController
public class TableController {

    private final TableService tableService;
    private final ReservationService reservationService;
    private final RestaurantService restaurantService;

    @Autowired
    public TableController(TableService tableService, ReservationService reservationService, RestaurantService restaurantService){
        this.tableService = tableService;
        this.reservationService = reservationService;
        this.restaurantService = restaurantService;
    }

    @PostMapping(value = "/tables")
    public ResponseEntity<?> create(@RequestBody TableDto tableDto){

        Restaurant restaurant = restaurantService.read(tableDto.getRestaurant_id());
        Table table = MappingUtils.mapToTable(tableDto, restaurant);
        List<Table> newTables = restaurant.getTables();
        newTables.add(table);
        restaurant.setTables(newTables);
        tableService.create(table);
        restaurantService.update(restaurant, tableDto.getRestaurant_id());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/tables/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody TableDto tableDto){

        Table table = tableService.read(id);
        Integer olId = table.getRestaurant().getId();
        Restaurant olRes = restaurantService.read(olId);
        Restaurant restaurant = restaurantService.read(tableDto.getRestaurant_id());
        MappingUtils.mapToTableUpdate(tableDto, table, restaurant);
        restaurantService.update(olRes, olId);
        restaurantService.update(restaurant, tableDto.getRestaurant_id());
        final boolean updated = tableService.update(table, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/tables")
    @ResponseBody
    public ResponseEntity<List<Table>> read(@RequestParam(required = false) String date) throws ParseException {

        List<Table> tables;
        tables = tableService.readAll();

        if (date != null) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            cal.setTime(sdf.parse(date));// all done

            for (Table tmp: tables){
                List<Reservation> tpn = reservationService.findByDay(cal, tmp);
                tmp.setReservations(tpn);
            }
        }

        return !tables.isEmpty()
                ? new ResponseEntity<>(tables, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tables/{id}")
    @ResponseBody
    public ResponseEntity<Table> read(@RequestParam(required = false) String date, @PathVariable(name = "id") int id) throws ParseException {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        cal.setTime(sdf.parse(date));// all done

        Table table = tableService.read(id);
        List<Reservation> tpn = reservationService.findByDay(cal, table);
        table.setReservations(tpn);

        return table != null
                ? new ResponseEntity<>(table, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/tables/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean deleted = tableService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
