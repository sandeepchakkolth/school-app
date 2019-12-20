/**
 * 
 */
package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author etwxaau
 *
 */
@Entity
@Table(name = "studentdetails")
public class Student {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 
	 @Column(name = "firstname")
	 private String firstName;
	 
	 @Column(name = "lastname")
	 private String lastName; 
	 
	 @Column(name = "fathername")
	 private String fatherName;
	 
	 @Column(name = "mothername")
	 private String motherName;
	 
	 @Column(name = "contactnumber")
	 private String contactNumber;
	 
	 @Column(name = "currentclass")
	 private String currentClass;
	 
	 @Column(name = "bloodgroup")
	 private String bloodGroup;
	 
	 @Column(name = "sex")
	 private String sex;
	 
	 @Column(name = "fatheroccupation")
	 private String fatherOccupation;
	 
	 @Column(name = "motheroccupation")
	 private String motherOccupation;
	 
	 @Column(name = "address")
	 private String address;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the fatherName
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the motherName
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * @param motherName the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the currentClass
	 */
	public String getCurrentClass() {
		return currentClass;
	}

	/**
	 * @param currentClass the currentClass to set
	 */
	public void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}

	/**
	 * @return the bloodGroup
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the fatherOccupation
	 */
	public String getFatherOccupation() {
		return fatherOccupation;
	}

	/**
	 * @param fatherOccupation the fatherOccupation to set
	 */
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	/**
	 * @return the motherOccupation
	 */
	public String getMotherOccupation() {
		return motherOccupation;
	}

	/**
	 * @param motherOccupation the motherOccupation to set
	 */
	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}
