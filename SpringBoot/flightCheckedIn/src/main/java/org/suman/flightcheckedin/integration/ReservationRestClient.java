package org.suman.flightcheckedin.integration;

import org.suman.flightcheckedin.entities.Reservation;
import org.suman.flightcheckedin.entities.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

    public Reservation findReservation(long id);

    public Reservation updateReservation(ReservationUpdateRequest request);
}
