package com.usa.misiontic23.masterclass3.repository.crudRepository;



import com.usa.misiontic23.masterclass3.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    @Query("SELECT c.client, count(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY count (c.client) DESC")
    public List <Object[]> countTotalReservationByClient();
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);
    public List<Reservation> findAllByStatus(String status);
}
