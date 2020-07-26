package com.yaswanth.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// Here @JsonProperty annaotation is used write our own name for properties.
// @JsonInclude annoatation is used do some operations like omiting null values an d soon....
// we can also sort the order of properties using @JsonPropertyOrder annoatation
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties({"Student_Mobile_No"})
@JsonPropertyOrder({"Student_Name", "Student_Mobile_No"})
public class Student {
	
	@JsonProperty("Student_Name")
	private String studentName;
    
	@JsonProperty("Student_Mobile_No")
	private String studentMobileNo;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMobileNo() {
		return studentMobileNo;
	}

	public void setStudentMobileNo(String studentMobileNo) {
		this.studentMobileNo = studentMobileNo;
	}

}
