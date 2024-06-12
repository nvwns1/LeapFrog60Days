package org.suman.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.suman.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
