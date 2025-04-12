package com.mh.spring.finalex.controller;

import com.mh.spring.finalex.model.Reservation;
import com.mh.spring.finalex.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable String id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.orElse(null);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable String id, @RequestBody Reservation updatedRes) {
        return reservationRepository.findById(id)
                .map(res -> {
                    res.setFirstName(updatedRes.getFirstName());
                    res.setLastName(updatedRes.getLastName());
                    res.setNumberOfPassengers(updatedRes.getNumberOfPassengers());
                    res.setSeatClass(updatedRes.getSeatClass());
                    res.setPhoneNumber(updatedRes.getPhoneNumber());
                    res.setDateOfDeparting(updatedRes.getDateOfDeparting());
                    res.setPaymentId(updatedRes.getPaymentId());
                   
                    return reservationRepository.save(res);
                })
                .orElseGet(() -> {
                    updatedRes.setId(id);
                    return reservationRepository.save(updatedRes);
                });
    }

    @DeleteMapping("/{id}")
    public String deleteReservation(@PathVariable String id) {
        reservationRepository.deleteById(id);
        return "Reservation with ID " + id + " has been deleted.";
    }
}
