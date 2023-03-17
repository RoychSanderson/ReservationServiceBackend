package com.example.reservationback.service;

import com.example.reservationback.model.User;
import com.example.reservationback.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public User read(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public boolean update(User user, int id) {
        if (userRepository.existsById(id)){
            user.setId(id);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
