package com.cg.doctor.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.doctor.repository.DoctorRepository;
import com.cg.doctor.domain.MedicalHistory;
import com.cg.doctor.exception.PatientNotFoundException;
/** This class elaborates on service Implementation
* 
* @author Nidhi
* 
*/  
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository repository;
	/**This method is to add patient medical history */
	@Override
	public MedicalHistory addMedicalHistory(MedicalHistory medHistory) {
			return repository.save(medHistory);
	}
	/**This method is to get one particular medical record using medical record id primary key value */
	@Override
	public ResponseEntity<MedicalHistory> getMedicalRecordById(Integer medicalRecordId) throws PatientNotFoundException {
			MedicalHistory medHistory = repository.findById(medicalRecordId)
					.orElseThrow(() -> new PatientNotFoundException("Patient Not found for " + medicalRecordId));
			return ResponseEntity.ok().body(medHistory);
		
	}
	/**This method is to get all the medical history of one particular patient */
	@Override
	public ResponseEntity<List<MedicalHistory>> getMedicalHistoryByPatientId(Integer patientId) throws PatientNotFoundException {
		List<MedicalHistory> list=repository.findMedicalRecordByPatientId(patientId);
			if(list.isEmpty())
			{
				throw new PatientNotFoundException("Patient Not found for " + patientId);
			}
			else
			{
				return  ResponseEntity.ok().body(list);
			}
		}
}