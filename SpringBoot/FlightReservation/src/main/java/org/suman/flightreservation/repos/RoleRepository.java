package org.suman.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suman.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
