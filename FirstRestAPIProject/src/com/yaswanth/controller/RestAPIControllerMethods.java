package com.yaswanth.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RestAPIControllerMethods {
	// if you use @RestController at class then no need to give @ResponseBody at all
	// the methods.
	// if yu want support the method request only for specific format then we have
	// to use produces=MediaType.your required format.
	// @ResponseBody

	@RequestMapping(value = "/studentlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public ArrayList<Student> getAllStudents() {
		Student student1 = new Student();
		student1.setStudentName("yaswanth");

		Student student2 = new Student();
		student2.setStudentName("Nikhilesh");

		Student student3 = new Student();
		student3.setStudentName("Rama");

		ArrayList<Student> studentlist = new ArrayList<Student>();
		studentlist.add(student1);
		studentlist.add(student2);
		studentlist.add(student3);
		return studentlist;

	}

	// @ResponseBody
	@RequestMapping(value = "/studentlist/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName) {

		Student s = new Student();
		s.setStudentName(studentName);
		s.setStudentMobileNo("9866332422");

		return s;
	}

	// Here in the method we passed @RequestBody it will convert the input format
	// into java object format.
	@RequestMapping(value = "/updatestudent/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_XML_VALUE)
	public boolean updateStudentDetails(@PathVariable("name") String studentName, @RequestBody Student student) {
		System.out.println("Student Name :" + studentName);
		System.out.println(
				"student Name :" + student.getStudentName() + "student Mobile No :" + student.getStudentMobileNo());
		return true;
	}

	// Here in the method we passed @RequestBody it will convert the input format
	// into java object format.
	// Here we have used @ResponseEntity to return our own custon status code for
	// the output without sending the actual output.
	@RequestMapping(value = "/updatestudentlist/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateStudentDetails1(@PathVariable("name") String studentName,
			@RequestBody Student student) {
		System.out.println("Student Name :" + studentName);
		System.out.println(
				"student Name :" + student.getStudentName() + "student Mobile No :" + student.getStudentMobileNo());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Key1", "yaswanth");
		headers.add("Key2", "yaswanth1");
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
    
	//Here RequestMethod.POST will used to insert the records into DB.
	@RequestMapping(value = "/insertstudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Boolean> insertStudent(@RequestBody Student student) {
		
		
		System.out.println("Student Name :" + student.getStudentName() + "-----" + "Student Mobile No :"
				+ student.getStudentMobileNo());
         
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
				.buildAndExpand(student.getStudentName()).toUri().toString());
		
		return new ResponseEntity<Boolean>(headers,HttpStatus.OK);
	}
	@RequestMapping(value = "/deletestudent/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteStudent(@RequestBody String studentName) {
         
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	@RequestMapping(value = "/deleteAllstudent", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAllStudent(@RequestBody Student student) {
         
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
				.buildAndExpand(student.getStudentName()).toUri().toString());
		
		return new ResponseEntity<Boolean>(headers,HttpStatus.OK);
	}
	
}
