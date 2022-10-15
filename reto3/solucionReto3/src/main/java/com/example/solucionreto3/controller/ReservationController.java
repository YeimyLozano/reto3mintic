package com.example.solucionreto3.controller;


import com.example.solucionreto3.entities.Message;
import com.example.solucionreto3.entities.Reservation;
import com.example.solucionreto3.services.MessageService;
import com.example.solucionreto3.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getMessage(@PathVariable("id") int reservationId){
        return reservationService.getReservation(reservationId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p) {
        return reservationService.save(p);
    }

    @PutMapping("/update")
    public Reservation update (@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int carId){
        return reservationService.delete(carId);
    }
}
