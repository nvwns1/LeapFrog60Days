package org.suman.flightreservation.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @RequestMapping("/reservation/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        LOGGER.info("Find reservation with id {}", id);
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (!reservation.isPresent()) {
            LOGGER.error("Reservation not found");
            throw new RuntimeException("Reservation not found");
        }
        return reservation.get();
    }

    @RequestMapping("/reservation")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        LOGGER.info("Inside updateReservation() for"+ request);

        Optional<Reservation> reservation = reservationRepository.findById(request.getId());
        if (!reservation.isPresent()) {
            LOGGER.error("Reservation not found");
            throw new RuntimeException("Reservation not found");
        }
        Reservation reservedReservation = reservation.get();
        reservedReservation.setNumberOfBags(request.getNumberOfBag());
        reservedReservation.setCheckedIn(request.getCheckedIn());
        LOGGER.info("Saving Reservation");
        return reservationRepository.save(reservedReservation);
    }
}
