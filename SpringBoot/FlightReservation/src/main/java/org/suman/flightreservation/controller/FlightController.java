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
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);


    @Autowired
    FlightRepository flightRepository;

    @RequestMapping(value = "/findFlights", method = RequestMethod.POST)
    public String findFlights(@ModelAttribute("searchData") FlightSearchDTO flightSearchDTO, Model model) {

        LOGGER.info("Inside Find Flights" + flightSearchDTO);
        String from = flightSearchDTO.getFrom();
        String to = flightSearchDTO.getTo();
//        Date departureDate = flightSearchDTO.getDepartureDate();

        List<Flight> flights = flightRepository.findFlights(from, to);
        model.addAttribute("flights", flights);

        LOGGER.info("Flight Found are: "+ flights); ;
        return "displayFlights";
    }

    @RequestMapping("admin/showAddFlight")
    public String showAddFlight(Flight flight) {
        return "addFlight";
    }
}
