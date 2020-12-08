package com.cg.doctor.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.doctor.domain.MedicalHistory;
/** This class defines the test case for methods in repository class
* 
* @author Sandhya and Amrutha
* 
*/
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
class DoctorRepositoryTests {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	/** to test add medical history in the repository class */
	@Test
	void testAddMedicalHistory() {
		MedicalHistory medicine = getMedicalHistory();
		MedicalHistory saveInDb = testEntityManager.persist(medicine);
		MedicalHistory getInDb = doctorRepository.findById(medicine.getMedicalRecordId()).get();
	    assertThat(getInDb).isEqualTo(saveInDb);
	    }
	/** to test get medical record by id in the repository class */
	 @Test
	 void testGetMedicalRecordById()throws Exception{
		 MedicalHistory medHistory = new MedicalHistory();
			medHistory.setMedicalRecordId(15);
			medHistory.setPatientId(12);
			medHistory.setPatientName("aaa");
			medHistory.setDiagnosis("xxx");
			medHistory.setTreatment("sss");
			medHistory.setDoctorName("kkk");
			medHistory.setDate(LocalDateTime.now());
	       
	        //Insert Data into in memory database
	        MedicalHistory saveInDb = testEntityManager.persist(medHistory);
	        //Get Data from DB
	        MedicalHistory getInDb = doctorRepository.findById(medHistory.getMedicalRecordId()).get();
	        assertThat(getInDb).isEqualTo(saveInDb);
	    }
	 	/** to test find mdical history by patient id in the repository class */
	   	@Test
	    void testFindMedicalHistoryByPatientId()throws Exception{
		   MedicalHistory medHistory = new MedicalHistory();
			medHistory.setMedicalRecordId(15);
			medHistory.setPatientId(12);
			medHistory.setPatientName("aaa");
			medHistory.setDiagnosis("xxx");
			medHistory.setTreatment("sss");
			medHistory.setDoctorName("kkk");
			medHistory.setDate(LocalDateTime.now());
	       
			MedicalHistory saveInDb = testEntityManager.persist(medHistory);

	        List<MedicalHistory> doc1 = new ArrayList<>();
	        doc1.add(saveInDb);
	        assertThat(doc1.size()).isEqualTo(1);

	    }

	private MedicalHistory getMedicalHistory() {
		MedicalHistory medHistory = new MedicalHistory();
		medHistory.setMedicalRecordId(15);
		medHistory.setPatientId(12);
		medHistory.setPatientName("aaa");
		medHistory.setDiagnosis("xxx");
		medHistory.setTreatment("sss");
		medHistory.setDoctorName("kkk");
		medHistory.setDate(LocalDateTime.now());
		return medHistory;
	}

}