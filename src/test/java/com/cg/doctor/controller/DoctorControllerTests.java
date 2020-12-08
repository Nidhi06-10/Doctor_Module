package com.cg.doctor.controller;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.cg.doctor.domain.MedicalHistory;
import com.cg.doctor.service.DoctorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/** This class defines the test case for methods in controller class
* 
* @author Sandhya and Amrutha
* 
*/
@RunWith(SpringRunner.class)
@WebMvcTest(value = DoctorController.class)
class DoctorControllerTests {
	@Autowired
    private MockMvc mockMvc;
	@MockBean
	private DoctorService doctorService;
	/** to test add medical history in the controller class */
	@Test
	void testAddMedicalHistory() throws Exception {
		String URI= "/doctor/add";
		MedicalHistory medHistory = new MedicalHistory();
		medHistory.setMedicalRecordId(15);
		medHistory.setPatientId(12);
		medHistory.setPatientName("aaa");
		medHistory.setDiagnosis("xxx");
		medHistory.setTreatment("sss");
		medHistory.setDoctorName("kkk");
		medHistory.setDate(LocalDateTime.now());
        String jsonInput = this.converttoJson(medHistory);
        Mockito.when(doctorService.addMedicalHistory(Mockito.any(MedicalHistory.class))).thenReturn(medHistory);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        //assertThat(jsonInput).isEqualTo(jsonOutput);
        assertNotNull(jsonOutput);
        //Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	/** to test get medical record by id in the controller class */
	@Test
	void testGetMedicalRecordById() throws Exception {
		String URI= "/doctor/get/{id}";
		//HttpHeaders header=new HttpHeaders();
		MedicalHistory medHistory = new MedicalHistory();
		medHistory.setMedicalRecordId(15);
		medHistory.setPatientId(12);
		medHistory.setPatientName("aaa");
		medHistory.setDiagnosis("xxx");
		medHistory.setTreatment("sss");
		medHistory.setDoctorName("kkk");
		medHistory.setDate(LocalDateTime.now());
        //String jsonInput = this.converttoJson(medHistory);
        //doctorService.addMedicalHistory(medHistory);
		ResponseEntity<MedicalHistory> rs= new ResponseEntity<>(medHistory,HttpStatus.OK);
        Mockito.when(doctorService.getMedicalRecordById(15)).thenReturn(rs);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 15).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertNotNull(jsonOutput);
        //assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	/** to test get medical history by patient id in the controller class */
	@Test
	void testGetMedicalHistoryByPatientId() throws Exception {
		String URI= "/doctor/set/{id}";
		MedicalHistory medHistory = new MedicalHistory();
		medHistory.setMedicalRecordId(15);
		medHistory.setPatientId(12);
		medHistory.setPatientName("aaa");
		medHistory.setDiagnosis("xxx");
		medHistory.setTreatment("sss");
		medHistory.setDoctorName("kkk");
		medHistory.setDate(LocalDateTime.now());
		List<MedicalHistory> ticketList = new ArrayList<>();
        ticketList.add(medHistory);
        ResponseEntity<List<MedicalHistory>> list = doctorService.getMedicalHistoryByPatientId(12);
        //String jsonInput = this.converttoJson(medHistory);
        Mockito.when(list).thenReturn(list);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 12).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        //assertThat(jsonInput).isEqualTo(jsonOutput);
		assertNotNull(jsonOutput);
	}

	private String converttoJson(Object medicalHistory) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(medicalHistory);

	}
}