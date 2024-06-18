package org.suman.flightreservation.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suman.flightreservation.entities.DTO.ReservationRequestDTO;
import org.suman.flightreservation.entities.Flight;
import org.suman.flightreservation.entities.Passenger;
import org.suman.flightreservation.entities.Reservation;
import org.suman.flightreservation.repos.FlightRepository;
import org.suman.flightreservation.repos.PassengerRepository;
import org.suman.flightreservation.repos.ReservationRepository;
import org.suman.flightreservation.services.ReservationService;
import org.suman.flightreservation.util.PDFGenerator;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    private ReservationRepository reservationRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Override
    public Reservation bookFlight(ReservationRequestDTO request) {
        LOGGER.info("Inside bookFlight()");

        // Make Payment
        Long flightId = request.getFlightId();
        LOGGER.info("Fetching flight for flight id" + flightId);

        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        if (!flightOptional.isPresent()) {
            throw new RuntimeException("Flight not found");
        }
        Flight flight = flightOptional.get();


        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        LOGGER.info("Saving the passenger" + passenger);

        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();

        reservation.setPassenger(savedPassenger);
        reservation.setFlight(flight);
        reservation.setCheckedIn(false);

        Reservation savedReservation = reservationRepository.save(reservation);

        LOGGER.info("Saving the reservation" + savedReservation);
        LOGGER.info("Generating Itinerary");

        pdfGenerator.generateItinerary(savedReservation, "E:\\reservation/" + savedReservation.getId() + ".pdf");


        return savedReservation;
    }
}
