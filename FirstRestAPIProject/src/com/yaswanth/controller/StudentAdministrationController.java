package com.yaswanth.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdministrationController {
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView model1=new ModelAndView("AdmissionForm");
		
		return model1;
	}
	
	
	@ModelAttribute
	public void addingCommonObjects(Model model1) {
	model1.addAttribute("headerMessage","Sathyabama Institute of science and technology");
	}
	
	@RequestMapping(value="/submission",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm( @ModelAttribute("student1")Student student1) {
		
		ModelAndView model1=new ModelAndView("AdmissionSuccess");
		
		return model1;
	}
	
	

}
