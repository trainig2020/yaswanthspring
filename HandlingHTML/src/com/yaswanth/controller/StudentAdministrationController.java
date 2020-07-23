package com.yaswanth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdministrationController {
    @RequestMapping(value="/",method = RequestMethod.GET)  
	public ModelAndView getAdmistrationForm() {
    	  ModelAndView modelAndView = new ModelAndView("AdmissionForm");
    	  return modelAndView;
      }
    @RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
    public ModelAndView submitAdmissionForm(@RequestParam("studentName") String name,@RequestParam("studentHobby") String hobby) {
    	
    	ModelAndView model = new ModelAndView("AdmissionSuccess");
    	model.addObject("msg", "Details Submitted by you:: Name:"+name+ ", Hobby :" + hobby);
    	
    	return model;
    }
}
