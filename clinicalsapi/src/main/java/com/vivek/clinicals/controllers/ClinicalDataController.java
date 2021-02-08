package com.vivek.clinicals.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.clinicals.dto.ClinicalDataRequest;
import com.vivek.clinicals.models.ClinicalData;
import com.vivek.clinicals.models.Patient;
import com.vivek.clinicals.repositories.ClinicalDataRepo;
import com.vivek.clinicals.repositories.PatientRepo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ClinicalDataController {

	@Autowired
	private ClinicalDataRepo clinicalDataRepo;

	@Autowired
	private PatientRepo patientRepo;

	@PostMapping("/clinicals")
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
		Patient patient = patientRepo.findById(request.getPatientId()).get();
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setComponentValue(request.getComponentValue());
		clinicalData.setPatient(patient);
		return clinicalDataRepo.save(clinicalData);

	}

}
