package com.cg.doctor.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cg.doctor.domain.Prescription;
import org.springframework.stereotype.Repository;


/** 
 * This is an interface which defines CRUD methods for patient JPA repository
 * @author Amrutha and Sandhya
 *
 * 
 */
@Repository
public interface PrescriptionRepository  extends  JpaRepository<Prescription,Integer>{
	@Query("SELECT c FROM Prescription c WHERE c.prescriptionId = :prescriptionId")
	Prescription findByPrescriptionId(int prescriptionId);
	


}
