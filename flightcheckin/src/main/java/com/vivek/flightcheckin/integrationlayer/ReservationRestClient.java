package com.vivek.flightcheckin.integrationlayer;

import com.vivek.flightcheckin.integration.dto.Reservation;
import com.vivek.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
