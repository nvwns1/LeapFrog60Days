package org.suman.flightreservation.services.Impl;

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

    @Override
    public Reservation bookFlight(ReservationRequestDTO request) {

        // Make Payment
        Long flightId = request.getFlightId();
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

        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();

        reservation.setPassenger(savedPassenger);
        reservation.setFlight(flight);
        reservation.setCheckedIn(false);

        Reservation savedReservation = reservationRepository.save(reservation);

        pdfGenerator.generateItinerary(savedReservation, "E:\\reservation/"+savedReservation.getId()+".pdf");


        return savedReservation;
    }
}
