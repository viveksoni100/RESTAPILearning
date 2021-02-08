package com.vivek.flightreservation;

import java.time.LocalDateTime;

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

//	@Test
//	void addPassenger() {
//		Passenger passenger = new Passenger();
//		passenger.setFirstName("Vivek");
//		passenger.setLastName("Soni");
//		passenger.setEmail("viveksoni100@gmail.com");
//		passenger.setPhone("8866128862");
//		passangerRepo.save(passenger);
//		System.out.println("Done 6e bro...");
//	}

//	@Test
//	void doReservation() {
//		Flight flight = flightrep.findById(1L).get();
//		Passenger passenger = passangerRepo.findById(1L).get();
//		Reservation reservation = new Reservation();
//		reservation.setCheckedIn(true);
//		reservation.setNumberOfBags(5);
//		reservation.setPassanger(passenger);
//		reservation.setFlight(flight);
//		Reservation savedReservation = reservationRepo.save(reservation);
//		System.out.println("Reservation is saved : " + savedReservation);
//	}

//	@Test
//	void addFlight() {
//		Flight flight = new Flight();
//		flight.setArrivalCity("AMD");
//		flight.setDateOfDeparture(LocalDateTime.now());
//		flight.setDepartureCity("RJT");
//		flight.setEstimatedDepartureTime(LocalDateTime.now());
//		flight.setFlightNumber("2018-02-06");
//		flight.setOperatingAirlines("Indian Airways");
//		flightrep.save(flight);
//	}

}
