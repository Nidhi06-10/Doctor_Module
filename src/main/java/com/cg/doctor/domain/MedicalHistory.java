
package com.cg.doctor.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* This class elaborates on MedicalHistory entity 
* 
* @author Nidhi
* 
*/
@Entity
@Table(name = "MEDICALHISTORY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MedicalHistory implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable = false)   
	@NotNull(message="Please provide Id value")
	private int medicalRecordId;
	@Column (name = "PATIENTId",nullable = false) 
	private int patientId;
	@Column(nullable = false)
	@NotBlank(message="Please provide patient name details")
	private String patientName ;
	@Column(nullable = false)
	@NotBlank(message="Please provide diagnosis details")
	private String diagnosis;  
	@Column(nullable = false)
	@NotBlank(message="Please provide treatment details")
	private String treatment;
	@Column(nullable = false)
	@NotBlank(message="Please provide doctor name details")
	private String doctorName;
	@Column
	private LocalDateTime date;	
	public LocalDateTime getDate() {
		return date;
	}  
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(int medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	@Override  
	public String toString() {
		return "MedicalHistory [MedicalRecordId=" + medicalRecordId +", patientId=" + patientId + ", patientName=" + patientName + ", diagnosis=" + diagnosis
				+ ", treatment=" + treatment + ", doctorName=" + doctorName + ", date=" + date + "]";
	}
	public MedicalHistory(int medicalRecordId,int patientId, String patientName, String diagnosis, String treatment, String doctorName,
			LocalDateTime date) {
		super();
		this.medicalRecordId=medicalRecordId;
		this.patientId = patientId;
		this.patientName = patientName;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.doctorName = doctorName;
		this.date = date;
	}
	public MedicalHistory()
	{
		
	}
}