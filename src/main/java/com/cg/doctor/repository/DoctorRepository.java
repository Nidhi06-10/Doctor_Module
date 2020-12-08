package com.cg.doctor.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.doctor.domain.MedicalHistory;
/** This interface define dao repository
* 
* @author Nidhi
* 
*/
@Repository
public interface DoctorRepository extends JpaRepository<MedicalHistory, Integer>{
	@Query("SELECT c FROM MedicalHistory c WHERE c.patientId = :patientId")
	List<MedicalHistory> findMedicalRecordByPatientId(int patientId);

}
