package org.suman.flightcheckedin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.suman.flightcheckedin.entities.Reservation;
import org.suman.flightcheckedin.entities.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    @Override
    public Reservation findReservation(long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/reservation/" + id, Reservation.class);
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:8080/reservation", request, Reservation.class);
    }
}
