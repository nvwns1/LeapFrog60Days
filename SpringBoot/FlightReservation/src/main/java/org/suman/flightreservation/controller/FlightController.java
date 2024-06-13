package org.suman.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.suman.flightreservation.entities.DTO.FlightSearchDTO;
import org.suman.flightreservation.entities.Flight;
import org.suman.flightreservation.repos.FlightRepository;

import java.util.List;

@Controller
public class FlightController {
    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);


    @Autowired
    FlightRepository flightRepository;

    @RequestMapping(value = "/findFlights", method = RequestMethod.POST)
    public String findFlights(@ModelAttribute("searchData") FlightSearchDTO flightSearchDTO, Model model) {
        System.out.println("RUNNING 1 ...");

        String from = flightSearchDTO.getFrom();
        String to = flightSearchDTO.getTo();
//        Date departureDate = flightSearchDTO.getDepartureDate();
        logger.info("Searching flights from: {} to: {} on date: {}", from, to);


        List<Flight> flights = flightRepository.findFlights(from, to);
        model.addAttribute("flights", flights);

        System.out.println("RUNNING ...");
        return "displayFlights";
    }
}
