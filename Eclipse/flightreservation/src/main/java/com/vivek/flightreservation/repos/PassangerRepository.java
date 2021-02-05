package com.vivek.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.flightreservation.entities.Passenger;

public interface PassangerRepository extends JpaRepository<Passenger, Long> {

}
