package com.usa.misiontic23.masterclass3.repository;


import com.usa.misiontic23.masterclass3.entities.Client;
import com.usa.misiontic23.masterclass3.entities.CountClient;
import com.usa.misiontic23.masterclass3.entities.Reservation;
import com.usa.misiontic23.masterclass3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
@Repository

public class ReservationRepository {

    //public static List<Reservation> getALL;
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
    public List<CountClient> getClientesTop(){
        List<CountClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCrudRepository.countTotalReservationByClient();
        for (int i=0; i<reporte.size(); i++){
            respuesta.add(new CountClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }

    public List<Reservation> getReservationBetweenDays(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(a, b);
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
}
