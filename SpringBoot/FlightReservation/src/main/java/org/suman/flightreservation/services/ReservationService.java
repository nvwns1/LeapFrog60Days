package org.suman.flightreservation.services;

import org.suman.flightreservation.entities.DTO.ReservationRequestDTO;
import org.suman.flightreservation.entities.Reservation;

public interface ReservationService {
    public Reservation bookFlight(ReservationRequestDTO request);
}
