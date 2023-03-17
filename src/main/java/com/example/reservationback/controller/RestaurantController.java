package com.example.reservationback.controller;

import com.example.reservationback.model.Restaurant;
import com.example.reservationback.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping(value = "/restaurants")
    public ResponseEntity<List<Restaurant>> read() {
        final List<Restaurant> restaurants = restaurantService.readAll();
        return restaurants != null && !restaurants.isEmpty()
                ? new ResponseEntity<>(restaurants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/restaurants/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id, @RequestBody Restaurant restaurant){
        final boolean updated = restaurantService.update(restaurant, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping(value = "/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant restaurant){
        restaurantService.create(restaurant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
