package com.example.reservationback.service;

import com.example.reservationback.model.Table;
import com.example.reservationback.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService{

    private final TableRepository tableRepository;

    public TableServiceImpl(TableRepository tableRepository){
        this.tableRepository = tableRepository;
    }

    @Override
    public void create(Table table) {
        tableRepository.save(table);
    }

    @Override
    public List<Table> readAll() {
        return tableRepository.findAll();
    }

    @Override
    public Table read(int id) {
        return tableRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Table table, Integer id) {
        if (tableRepository.existsById(id)) {
            table.setId(id);
            tableRepository.save(table);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        tableRepository.deleteById(id);
        return true;
    }
}
