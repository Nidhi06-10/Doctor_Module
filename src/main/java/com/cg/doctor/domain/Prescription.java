package com.cg.doctor.domain;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is an entity class for patients with getters and setters and constructor
 *
 * @author Nidhi
 *
 * 
 */
@Entity
@Table(name = "Prescription")


	public class Prescription implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private int prescriptionId;
	@Column
	private String patientName;
	@Column
	private String bloodGroup;
	@Column
	private int age;
	@Column
	private String mobileNumber;
	@Column
	private String address;
	@Column
	private String prescriptionDetails;

	/** constructor with arguments */
	public Prescription(int prescriptionId, String patientName, String bloodGroup, int age, String mobileNumber, String address,String prescriptionDetails) {
		super();
	    this.prescriptionId = prescriptionId;
		this.patientName = patientName;
		this.bloodGroup = bloodGroup;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.prescriptionDetails=prescriptionDetails;

	}

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}
  
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrescriptionDetails() {
		return prescriptionDetails;
	}

	public void setPrescriptionDetails(String prescriptionDetails) {
		this.prescriptionDetails = prescriptionDetails;
	}

	/** default constructor */
	public Prescription() {
		super();
	}

	@Override
	public String toString() {
		return "\n Patient prescriptionId=" + prescriptionId + "\n patientName=" + patientName + "\n bloodGroup=" + bloodGroup
				+ "\n age=" + age + "\n mobileNumber=" + mobileNumber + "\n address=" + address + "\n prescriptionDetails="
				+ prescriptionDetails + "\n-----------\n";
	}

}




