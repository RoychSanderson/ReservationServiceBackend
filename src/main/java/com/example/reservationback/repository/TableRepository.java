package com.example.reservationback.repository;

import com.example.reservationback.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table, Integer> {
}
