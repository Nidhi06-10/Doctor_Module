package com.cg.doctor.service;




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

import com.cg.doctor.domain.Prescription;
import com.cg.doctor.service.PrescriptionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/** This class defines the test case for methods in controller class
* 
* @author Amrutha and Sandhya
* 
*/
@RunWith(SpringRunner.class)
@WebMvcTest(value = PrescriptionService.class)
class PrescriptionServiceImplTests {


	@Autowired
    private MockMvc mockMvc;
	@MockBean
	private PrescriptionService prescriptionService;
	/** to test add medical history in the controller class */
	@Test
	void testAddPrescription() throws Exception {
		String URI= "/doctor/add";
		Prescription prescription= new Prescription();
		prescription.setPrescriptionId(15);
		prescription.setPatientName("nnn");
		prescription.setBloodGroup("mm");
		prescription.setAge(25);
		prescription.setAddress("kkk");
		prescription.setPrescriptionDetails("kkk");
        String jsonInput = this.converttoJson(prescription);
        Mockito.when(prescriptionService.addPrescription(Mockito.any(Prescription.class))).thenReturn(prescription);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertNotNull(jsonOutput);
	}
	private String converttoJson(Object prescription) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(prescription);

	}
}
