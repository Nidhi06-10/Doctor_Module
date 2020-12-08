package com.cg.doctor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.doctor.domain.MedicalHistory;
import com.cg.doctor.exception.PatientNotFoundException;
import com.cg.doctor.service.DoctorService;
/** This class elaborates on controller implementations
* 
* @author Nidhi
* 
*/   
@RestController
@RequestMapping("/doctor") 
@Validated
public class DoctorController {
	@Autowired	
	private DoctorService doctorService;
	
	/**This method is to add patient medical history */
	@PostMapping("/add")
	public MedicalHistory addMedicalHistory(@Valid @RequestBody MedicalHistory medicalHistory) {
		 return doctorService.addMedicalHistory(medicalHistory);   
	}
	/**This method is to get one particular medical record using medical record id primary key value */
	@GetMapping(value="/get/{medicalRecordId}")
	public ResponseEntity<MedicalHistory> getMedicalRecordById(@Valid @PathVariable(value = "medicalRecordId") Integer medicalRecordId) throws PatientNotFoundException{
		return doctorService.getMedicalRecordById(medicalRecordId); 
	}
	/**This method is to get all the medical history of one particular patient */
	@GetMapping(value="/set/{patientId}")
	public ResponseEntity<List<MedicalHistory>> getMedicalHistoryByPatientId(@Valid @PathVariable(value = "patientId") Integer patientId) throws PatientNotFoundException{
		return doctorService.getMedicalHistoryByPatientId(patientId);
	}
}
