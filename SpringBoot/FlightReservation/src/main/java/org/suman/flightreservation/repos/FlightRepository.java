package org.suman.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suman.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
