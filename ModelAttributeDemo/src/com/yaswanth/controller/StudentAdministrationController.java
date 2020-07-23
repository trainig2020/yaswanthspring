package com.yaswanth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdministrationController {
	@RequestMapping(value = "/studentAdmission", method = RequestMethod.GET)
	public ModelAndView getAdmistrationForm() {
		ModelAndView model = new ModelAndView("AdmissionForm");
		return model;
	}

	// IF YOU USE @RequestParam TO GET THE VALUES FROM HTML PAGE AND WANT TO PASS
	// THE VALUES AS AN OBJECT TO JSP WE HAVE CREATE A ENTITY CLASS
	// -FOR THOSE VALUES AND THEN SET THE VALUES TO THAT ENTITY OBJECT AND ADD THAT
	// OBJECT TO MODEL OBJECT THEN WE CAN USE THAT OBJECT IN JSP
	// -AND FETCH THE VALUES.

//    @RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
//    public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name,@RequestParam("studentHobby") String hobby) {
//    	
//    	Student student1 = new Student();
//    	student1.setStudentName("name");
//    	student1.setStudentHobby("hobby");
//    	
//    	ModelAndView model = new ModelAndView("AdmissionSuccess");
//    	model.addObject("msg", "Details Submitted by you:: Name:"+name+ ", Hobby :" + hobby);
//    	model.addObject("student1", student1);
//    	return model;
//    }
	
	
	

	// IN CASE OF @ModelAttribute WE NO NEED TO SET THE VALUES AND ALSO NO NEED TO
	// ADD THE OBJECT TO MODEL OBJECT
	// WE CAN PASS AS BELOW AND WE CAN FETCH IN JSP
	
	
	
   // THIS IS @ModelAttibute ON A METHOD
	@ModelAttribute
	public void commonMessageObjects(Model model) {
		model.addAttribute("headerMessage", "SRKR Enginnering College");
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1") Student student1) {

		ModelAndView model = new ModelAndView("AdmissionSuccess");
		//model.addObject("headerMessage", "SRKR College Of ENginnering");
		return model;
	}

}
