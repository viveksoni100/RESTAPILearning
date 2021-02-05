package com.vivek.flightreservation.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {

	@Column(name = "CHECKED_IN")
	private boolean checkedIn;
	
	@Column(name = "NUMBER_OF_BAGS")
	private int numberOfBags;
	
	@OneToOne
	private Passenger passenger;
	
	@OneToOne
	private Flight flight;
	
	@Column(name = "CREATED")
	private Timestamp created;

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	public Passenger getPassanger() {
		return passenger;
	}

	public void setPassanger(Passenger passanger) {
		this.passenger = passanger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
