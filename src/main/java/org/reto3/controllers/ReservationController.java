package org.reto3.controllers;

import org.reto3.entities.Reservation;
import org.reto3.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    //Attributes
    @Autowired
    ReservationService reservationService;

    //Constructor
    public ReservationController(ReservationService resertvationService) {
        this.reservationService = resertvationService;
    }

    //Methods
    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getReservation(){
        return new ResponseEntity<List<Reservation>>(this.reservationService.getAllReservations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Reservation>  getReservationById(@PathVariable("id") int id) {
        return new ResponseEntity<Reservation>(this.reservationService.getReservationById(id), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<List<Reservation>>  createReservation(@RequestBody Reservation reserv){
        this.reservationService.createReservation(reserv);
        return new ResponseEntity<List<Reservation>>(this.reservationService.getAllReservations(), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<List<Reservation>> updateReservation(@RequestBody Reservation reservation){
        this.reservationService.updateReservation(reservation.getIdReservation(), reservation);
        return new ResponseEntity<List<Reservation>>(reservationService.getAllReservations(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") int id){
        this.reservationService.deleteReservation(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
