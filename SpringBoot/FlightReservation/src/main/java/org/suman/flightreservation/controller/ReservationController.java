package org.suman.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.suman.flightreservation.entities.DTO.ReservationRequestDTO;
import org.suman.flightreservation.entities.Flight;
import org.suman.flightreservation.entities.Reservation;
import org.suman.flightreservation.repos.FlightRepository;
import org.suman.flightreservation.services.ReservationService;

import java.util.Optional;

@Controller
public class ReservationController {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, Model model) {
        Optional<Flight> flight = flightRepository.findById(flightId);
        if (flight.isPresent()) {
            Flight fl = flight.get();
            model.addAttribute("flight", fl);
            return "completeReservation";
        } else {
            model.addAttribute("error", "Flight not found");
            return "error";
        }
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequestDTO reservationRequestDTO, Model model) {
        System.out.println("running til here");
        Reservation reservation = reservationService.bookFlight(reservationRequestDTO);
        model.addAttribute("msg", "Reservation Created Successfully and Id is " + reservation.getId());
        return "reservationConfirmation";

    }

}
