package org.suman.flightreservation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.suman.flightreservation.entities.DTO.ReservationUpdateRequest;
import org.suman.flightreservation.entities.Reservation;
import org.suman.flightreservation.repos.ReservationRepository;

import java.util.Optional;

@RestController
public class ReservationRestController {
    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservation/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (!reservation.isPresent()) {
            throw new RuntimeException("Reservation not found");
        }
        return reservation.get();
    }

    @RequestMapping("/reservation")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        Optional<Reservation> reservation = reservationRepository.findById(request.getId());
        if (!reservation.isPresent()) {
            throw new RuntimeException("Reservation not found");
        }
        Reservation reservedReservation = reservation.get();
        reservedReservation.setNumberOfBags(request.getNumberOfBag());
        reservedReservation.setCheckedIn(request.getCheckedIn());

        return reservationRepository.save(reservedReservation);
    }
}
