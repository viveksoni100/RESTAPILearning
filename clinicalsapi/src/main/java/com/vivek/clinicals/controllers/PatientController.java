package com.vivek.clinicals.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.clinicals.models.ClinicalData;
import com.vivek.clinicals.models.Patient;
import com.vivek.clinicals.repositories.PatientRepo;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private PatientRepo patientRepo;
	Map<String, String> filters = new HashMap<String, String>();

	@GetMapping(value = "/patients")
	public List<Patient> getPatients() {
		return patientRepo.findAll();
	}

	@GetMapping(value = "/patients/{id}")
	public Patient getPatient(@PathVariable("id") int id) {
		return patientRepo.findById(id).get();
	}

	@PostMapping(value = "/patients")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientRepo.save(patient);
	}

	@GetMapping("/patients/analyze/{id}")
	public Patient analyze(@PathVariable("id") int id) {
		Patient patient = patientRepo.findById(id).get();
		List<ClinicalData> clinicalDatas = patient.getClinicalDatas();
		List<ClinicalData> dublicateClinicalDatas = new ArrayList<ClinicalData>();
		for (ClinicalData clinicalData : dublicateClinicalDatas) {

			if (filters.containsKey(clinicalData.getComponentName())) {
				clinicalDatas.remove(clinicalData);
				continue;
			} else {
				filters.put(clinicalData.getComponentName(), null);
			}

			if (clinicalData.getComponentName().equals("hw")) {
				String[] heightAndWeight = clinicalData.getComponentValue().split("/");
				if (heightAndWeight != null) {
					float heightInMeters = Float.parseFloat(heightAndWeight[0]) * 0.4536F;
					float bmi = Float.parseFloat(heightAndWeight[1]) / heightInMeters * heightInMeters;
					ClinicalData bmiData = new ClinicalData();
					bmiData.setComponentName("bmi");
					bmiData.setComponentValue(Float.toString(bmi));
					clinicalDatas.add(bmiData);
				}
			}
		}
		filters.clear();
		return patient;

	}

}
