package com.cg.doctor.exception;

import java.util.regex.*;

import com.cg.doctor.exception.PatientNotFoundException;
/*This class validates the input*/

public class DoctorValidator {
	public boolean validatePatientId(Integer patientId)throws PatientNotFoundException {
		String regex="^[0-9]*$";
		Pattern pat=Pattern.compile(regex);
		Matcher m=null;
		try {
		 m =pat.matcher(String.valueOf(patientId));
		}catch(NumberFormatException e) {
			throw new PatientNotFoundException("Invalid input, id should be a number");
			}
		return m.matches();
	}
}
