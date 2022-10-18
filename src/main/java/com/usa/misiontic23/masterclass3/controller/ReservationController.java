package com.usa.misiontic23.masterclass3.controller;


import com.usa.misiontic23.masterclass3.entities.CountClient;
import com.usa.misiontic23.masterclass3.entities.CountStatus;
import com.usa.misiontic23.masterclass3.entities.Reservation;
import com.usa.misiontic23.masterclass3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    /*
    @Autowired
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public List<Reservation> getALL(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation p){
        return reservationService.save(p);
    }
*/

    @Autowired
    private ReservationService reservationService;
    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {

        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {return reservationService.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){return reservationService.delete(id);}

    @GetMapping("/report-clients")
    public List<CountClient> getReportClientesTop(){
        return reservationService.getClientesTop();
    }

    @GetMapping("report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReportReservationBetweenDays(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationsBetweenDays(dateOne, dateTwo);
    }

    @GetMapping("report-status")
    public CountStatus getReportSatatus(){
        return reservationService.getReservationsStatus();
    }
}
