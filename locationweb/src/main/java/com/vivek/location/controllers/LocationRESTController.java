package com.vivek.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.location.entities.Location;
import com.vivek.location.repos.LocationRepo;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {
	
	@Autowired
	LocationRepo locationRepo;
	
	@GetMapping
	public List<Location> getLocations() { 
		return locationRepo.findAll();	//spring automatically serialize this into JSON
	}
	
	@PostMapping
	public Location createLocation(@RequestBody Location location) { //@RequestBody for serialization or deserialization
		return locationRepo.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location) { //@RequestBody for serialization or deserialization
		return locationRepo.save(location);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
		locationRepo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable("id") int id) { 
		return locationRepo.findById(id).get();	
	}
	
}
