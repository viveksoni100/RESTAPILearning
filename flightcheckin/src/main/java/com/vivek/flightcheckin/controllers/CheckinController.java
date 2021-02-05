package com.vivek.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vivek.flightcheckin.integration.dto.Reservation;
import com.vivek.flightcheckin.integration.dto.ReservationUpdateRequest;
import com.vivek.flightcheckin.integrationlayer.ReservationRestClient;

@Controller
public class CheckinController {

	@Autowired
	ReservationRestClient reservationrestClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckIn";
	}

	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modMap) {
		Reservation reservation = reservationrestClient.findReservation(reservationId);
		modMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}

	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
			@RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		reservationrestClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";
	}

}
