package com.cg.doctor.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.doctor.domain.Prescription;
import com.cg.doctor.service.PrescriptionService;

@RestController
@RequestMapping("/prescription") 
@Validated
public class PrescriptionController {
	
	@Autowired	
	private PrescriptionService prescriptionService;
	
	/**This method is to add patient medical history */
	@PostMapping("/add")
	public Prescription addPrescription(@Valid @RequestBody Prescription prescription) {
		 return prescriptionService.addPrescription(prescription) ; 
	}
	@PutMapping("/update/{prescriptionId}")
	public Prescription Update(@Valid @RequestBody Prescription prescription) {
		 return prescriptionService.saveOrUpdate(prescription) ; 
	}

	
}


