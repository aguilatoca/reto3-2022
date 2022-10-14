package com.usa.misiontic23.masterclass3.repository.crudRepository;



import com.usa.misiontic23.masterclass3.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
