package com.cg.doctor.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.doctor.repository.DoctorRepository;
import com.cg.doctor.domain.MedicalHistory;
/** This class defines the test case for methods in service class
* 
* @author Amrutha and Sandhya
* 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
class DoctorServiceImplTests {
	@Autowired
	private DoctorServiceImpl doctor;
	@MockBean
	private DoctorRepository repository;
	/** to test add medical history in the service class */
	@Test
	void testAddMedicalHistory() throws Exception{
		MedicalHistory medHistory = new MedicalHistory();
		medHistory.setMedicalRecordId(15);
		medHistory.setPatientId(12);
		medHistory.setPatientName("aaa");
		medHistory.setDiagnosis("xxx");
		medHistory.setTreatment("sss");
		medHistory.setDoctorName("kkk");
		medHistory.setDate(LocalDateTime.now());
		//dao.save(medHistory);
		Mockito.when(repository.save(medHistory)).thenReturn(medHistory);
        assertThat(doctor.addMedicalHistory(medHistory)).isEqualTo(medHistory);
		
	}
	/** to test get medical record by id in the service class */
	@Test
	void testGetMedicalRecordById() throws Exception {
		MedicalHistory medHistory = new MedicalHistory();
		medHistory.setMedicalRecordId(15);
		medHistory.setPatientId(12);
		medHistory.setPatientName("aaa");
		medHistory.setDiagnosis("xxx");
		medHistory.setTreatment("sss");
		medHistory.setDoctorName("kkk");
		medHistory.setDate(LocalDateTime.now());
		repository.save(medHistory);
        assertThat(medHistory.getMedicalRecordId()).isEqualTo(15);
	}
	/** to test get medical record by patient id in the service class */
	@Test
	void testGetMedicalHistoryByPatientId() throws Exception{
		MedicalHistory medHistory = new MedicalHistory();
		medHistory.setMedicalRecordId(15);
		medHistory.setPatientId(12);
		medHistory.setPatientName("aaa");
		medHistory.setDiagnosis("xxx");
		medHistory.setTreatment("sss");
		medHistory.setDoctorName("kkk");
		medHistory.setDate(LocalDateTime.now());
		List<MedicalHistory> list = new ArrayList<>();
        list.add(medHistory);
		Mockito.when(repository.findMedicalRecordByPatientId(12)).thenReturn(list);
        assertNotNull(list);
		
		
	}

}
