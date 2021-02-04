package com.vivek.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.location.entities.Location;

public interface LocationRepo extends JpaRepository<Location, Integer> {

}
