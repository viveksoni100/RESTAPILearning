package com.vivek.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vivek.flightreservation.entities.Flight;
import com.vivek.flightreservation.entities.Passenger;
import com.vivek.flightreservation.entities.Reservation;
import com.vivek.flightreservation.entities.User;
import com.vivek.flightreservation.repos.FlightRepository;
import com.vivek.flightreservation.repos.PassangerRepository;
import com.vivek.flightreservation.repos.ReservationRepository;
import com.vivek.flightreservation.repos.UserRepository;
import com.vivek.flightreservation.services.SecurityService;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	PassangerRepository passangerRepo;

	@Autowired
	FlightRepository flightrep;

	@Autowired
	ReservationRepository reservationRepo;
 
	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "registerUser";
	}
	
	@RequestMapping("/showLogin")
	@ResponseBody
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		boolean loginResponse = securityService.login(email, password);
		if (loginResponse) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "invalid username or password, please try again");
		}
		return "login";
	}
	
	@RequestMapping("/doReservation")
	public void doReservation() {
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
