package org.suman.flightcheckedin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.suman.flightcheckedin.entities.Reservation;
import org.suman.flightcheckedin.integration.ReservationRestClient;

@Controller
public class CheckInController {
    @Autowired
    ReservationRestClient reservationRestClient;

    @RequestMapping("/showStartCheckin")
    public  String showStartCheckIn(){
        return "startCheckIn";
    }

    @RequestMapping("/startCheckIn")
    public  String startCheckIn(@RequestParam("reservationId") long reservationId, Model model){
        Reservation reservation= reservationRestClient.findReservation(reservationId);
        model.addAttribute("reservation", reservation);
        return "displayReservationDetail";
    }
}
