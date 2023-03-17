package com.example.reservationback.service;

import com.example.reservationback.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    void create(Restaurant restaurant);

    List<Restaurant> readAll();

    Restaurant read(int id);

    boolean update(Restaurant restaurant, Integer id);

    boolean delete(int id);
}
