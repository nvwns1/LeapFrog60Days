package org.suman.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suman.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
