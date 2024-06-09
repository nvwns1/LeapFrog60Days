package org.suman.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suman.location.entities.Location;


public interface LocationRepository extends JpaRepository<Location, Integer> {

}
