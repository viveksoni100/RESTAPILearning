package com.vivek.clinicals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.clinicals.models.ClinicalData;

public interface ClinicalDataRepo extends JpaRepository<ClinicalData, Integer> {

}
