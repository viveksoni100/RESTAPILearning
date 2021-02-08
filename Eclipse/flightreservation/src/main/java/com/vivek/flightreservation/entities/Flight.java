package com.vivek.flightreservation.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Flight extends AbstractEntity {

	@Column(name = "FLIGHT_NUMBER")
	private String flightNumber;
	
	@Column(name = "OPERATING_AIRLINES")
	private String operatingAirlines;
	
	@Column(name = "DEPARTURE_CITY")
	private String departureCity;
	
	@Column(name = "ARRIVAL_CITY")
	private String arrivalCity;
	
	@Column(name = "DATE_OF_DEPARTURE")
	private LocalDateTime dateOfDeparture;
	
	@Column(name = "ESTIMATED_DEPARTURE_TIME")
	private LocalDateTime estimatedDepartureTime;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirlines() {
		return operatingAirlines;
	}

	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDateTime getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(LocalDateTime dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public LocalDateTime getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(LocalDateTime estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

}
