package com.vivek.flightreservation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vivek.flightreservation.entities.Flight;
import com.vivek.flightreservation.entities.Passenger;
import com.vivek.flightreservation.entities.Reservation;
import com.vivek.flightreservation.repos.FlightRepository;
import com.vivek.flightreservation.repos.PassangerRepository;
import com.vivek.flightreservation.repos.ReservationRepository;

@SpringBootTest
class FlightreservationApplicationTests {

	@Autowired
	PassangerRepository passangerRepo;

	@Autowired
	FlightRepository flightrep;

	@Autowired
	ReservationRepository reservationRepo;

	@Test
	void doReservation() {
		Flight flight = flightrep.findById(1L).get();
		Passenger passenger = passangerRepo.findById(1L).get();
		Reservation reservation = new Reservation();
		reservation.setCheckedIn(true);
		reservation.setNumberOfBags(5);
		reservation.setPassanger(passenger);
		reservation.setFlight(flight);
		Reservation savedReservation = reservationRepo.save(reservation);
		System.out.println("Resrvation is saved : " + savedReservation);
	}

}
