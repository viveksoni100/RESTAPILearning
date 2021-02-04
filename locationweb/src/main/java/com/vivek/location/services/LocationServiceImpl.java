package com.vivek.location.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vivek.location.entities.Location;
import com.vivek.location.repos.LocationRepo;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepo locationRepo;

	public LocationRepo getLocationRepo() {
		return locationRepo;
	}

	public void setLocationRepo(LocationRepo locationRepo) {
		this.locationRepo = locationRepo;
	}

	@Override
	public Location saveLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepo.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		// TODO Auto-generated method stub
		return locationRepo.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		// TODO Auto-generated method stub
		locationRepo.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		// TODO Auto-generated method stub
		return locationRepo.findById(id).get();
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return locationRepo.findAll();
	}

}
