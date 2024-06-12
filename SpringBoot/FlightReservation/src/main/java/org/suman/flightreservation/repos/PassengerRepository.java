package org.suman.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suman.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
