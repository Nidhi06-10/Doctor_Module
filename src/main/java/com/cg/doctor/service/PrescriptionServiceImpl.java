package com.cg.doctor.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.doctor.domain.Prescription;
import com.cg.doctor.repository.PrescriptionRepository;

@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService{

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public Prescription addPrescription(Prescription prescription) {
		return prescriptionRepository.save(prescription);
}
	

	
	public Prescription saveOrUpdate(Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}
}

