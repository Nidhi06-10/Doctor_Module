package com.cg.doctor.service;



import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.doctor.domain.MedicalHistory;
import com.cg.doctor.exception.PatientNotFoundException;
/** This class elaborates on service interface
* 
* @author Nidhi
* 
*/
public interface DoctorService {
	/**This method is to add patient medical history */
	public MedicalHistory addMedicalHistory(MedicalHistory medHistory);
	/**This method is to get one particular medical record using medical record id primary key value */
	public ResponseEntity<MedicalHistory> getMedicalRecordById(Integer medicalRecordId) throws PatientNotFoundException;
	/**This method is to get all the medical history of one particular patient */
	public ResponseEntity<List<MedicalHistory>> getMedicalHistoryByPatientId(Integer patientId) throws PatientNotFoundException;

}