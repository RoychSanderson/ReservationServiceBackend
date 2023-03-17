package com.example.reservationback.service;

import com.example.reservationback.model.Reservation;
import com.example.reservationback.model.Table;
import com.example.reservationback.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void create(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> readAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation read(Integer id) {
        return reservationRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Reservation reservation, Integer id) {
            reservation.setId(id);
            reservationRepository.save(reservation);
            return true;
    }

    @Override
    public boolean delete(int id) {
        reservationRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Reservation> findByDay(Calendar day, Table table) {
        Calendar begin = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        begin.set(day.get(Calendar.YEAR), day.get(Calendar.MONTH), day.get(Calendar.DATE), 0, 0);
        end.set(day.get(Calendar.YEAR), day.get(Calendar.MONTH), day.get(Calendar.DATE), 23, 59);
        return reservationRepository.findByTimeFromBetweenAndTableEquals(begin, end, table);
    }
}
