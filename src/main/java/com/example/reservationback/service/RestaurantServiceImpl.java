package com.example.reservationback.service;

import com.example.reservationback.model.Restaurant;
import com.example.reservationback.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void create(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> readAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant read(int id) {
        return restaurantRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Restaurant restaurant, Integer id) {
        if (restaurantRepository.existsById(id)) {
            restaurant.setId(id);
            restaurantRepository.save(restaurant);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        restaurantRepository.deleteById(id);
        return true;
    }
}
