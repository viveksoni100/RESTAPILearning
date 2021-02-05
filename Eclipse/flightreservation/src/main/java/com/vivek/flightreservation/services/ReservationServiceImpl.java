package com.vivek.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vivek.flightreservation.dto.ReservationRequest;
import com.vivek.flightreservation.entities.Flight;
import com.vivek.flightreservation.entities.Passenger;
import com.vivek.flightreservation.entities.Reservation;
import com.vivek.flightreservation.repos.FlightRepository;
import com.vivek.flightreservation.repos.PassangerRepository;
import com.vivek.flightreservation.repos.ReservationRepository;
import com.vivek.flightreservation.util.EmailUtil;
import com.vivek.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	private String ITINERARY_DIR = "/Users/Vivek/Documents/reservations/reservation";

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassangerRepository passangerRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		// TODO Auto-generated method stub

		// make payment
		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passanger = new Passenger();
		passanger.setFirstName(request.getPassengerFirstName());
		passanger.setLastName(request.getPassengerLastName());
		passanger.setPhone(request.getPassengerPhone());
		passanger.setEmail(request.getPassengerEmail());
		Passenger savedPassanger = passangerRepository.save(passanger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassanger(savedPassanger);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";
		pdfGenerator.generateItinerary(savedReservation,
				filePath);
		emailUtil.sendItinerary(passanger.getEmail(), filePath);

		return savedReservation;
	}

}
