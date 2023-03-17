package com.example.reservationback.service;

import com.example.reservationback.model.Table;

import java.util.List;

public interface TableService {
    void create(Table table);

    List<Table> readAll();

    Table read(int id);

    boolean update(Table table, Integer id);

    boolean delete(int id);
}
