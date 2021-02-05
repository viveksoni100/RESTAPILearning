package com.vivek.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.flightreservation.dto.ReservationUpdateRequest;
import com.vivek.flightreservation.entities.Reservation;
import com.vivek.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin // Without this angular will not work
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping("/reservations/{id}")
	public Optional<Reservation> findReservation(@PathVariable("id") Long id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		return reservation;
	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepository.save(reservation);
	}

}
