package com.springMongoDB.extractdata;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "employees")
public class Employees {

	@Id
	private String id;
	
	@Field ("empNo")
	private int empNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Field ("firstNname")
	private String firstName;
	@Field ("lastName")
	private String lastName;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		lastName = lastName;
	}

	public Employees(int empNo, String firstName, String lastName) {
		super();
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "employees [id=" + id + ",empNo=" + empNo + ",firstName=" + firstName + ",lastName=" + lastName + "]";
	}

}
