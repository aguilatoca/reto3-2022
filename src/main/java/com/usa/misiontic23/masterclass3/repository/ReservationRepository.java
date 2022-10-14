package com.usa.misiontic23.masterclass3.repository;

import com.usa.misiontic23.masterclass3.entities.Box;
import com.usa.misiontic23.masterclass3.entities.Reservation;
import com.usa.misiontic23.masterclass3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class ReservationRepository {

    public static List<Reservation> getAll;
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    public List<Reservation> getALL(){
        return (List<Reservation>) reservationCrudRepository.findAll();

    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation c){
        return reservationCrudRepository.save(c);
    }
    public void delete(Reservation c){
        reservationCrudRepository.delete(c);
    }
}