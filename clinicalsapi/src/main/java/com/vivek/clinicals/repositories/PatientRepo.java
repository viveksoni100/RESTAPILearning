package com.vivek.clinicals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.clinicals.models.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
