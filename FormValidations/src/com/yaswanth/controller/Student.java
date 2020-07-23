package com.yaswanth.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Size;

public class Student {
	@Size(min = 2,max = 7,message = "min characters are {min}")
	private String studentName;

	@Size(min = 2, message = "min characters are 2")
	private String studentHobby;

	private Long StudentMobile;
	private Date StudentDOB;
	private String studentSkills;

	private Address studentaddress;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentHobby() {
		return studentHobby;
	}

	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}

	public Long getStudentMobile() {
		return StudentMobile;
	}

	public void setStudentMobile(Long studentMobile) {
		StudentMobile = studentMobile;
	}

	public Date getStudentDOB() {
		return StudentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		StudentDOB = studentDOB;
	}

	public String getStudentSkills() {
		return studentSkills;
	}

	public void setStudentSkills(String studentSkills) {
		this.studentSkills = studentSkills;
	}

	public Address getStudentaddress() {
		return studentaddress;
	}

	public void setStudentaddress(Address studentaddress) {
		this.studentaddress = studentaddress;
	}

}
