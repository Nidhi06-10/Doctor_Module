package com.cg.doctor.service;

import javax.validation.Valid;

import com.cg.doctor.domain.Prescription;

public interface PrescriptionService {
	public Prescription addPrescription(Prescription prescription);
	public Prescription saveOrUpdate(@Valid Prescription prescription);

}	
	
