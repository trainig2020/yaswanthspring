package com.yaswanth.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdministrationController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getAdmistrationForm() throws Exception {

		String exceptionOccured = "ARITHMETIC_EXCEPTION";

		if (exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException("Null Pointer Exception");
		} else if (exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")) {

			throw new IOException("Io Exception");
		} else if (exceptionOccured.equalsIgnoreCase("ARITHMETIC_EXCEPTION")) {

			throw new ArithmeticException("ARITHMETIC_EXCEPTION");
		}

		ModelAndView model = new ModelAndView("AdmissionForm");
		return model;
	}

	@ModelAttribute
	public void commonMessageObjects(Model model) {
		model.addAttribute("headerMessage", "SRKR Enginnering College");
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1") Student student1) {

		ModelAndView model = new ModelAndView("AdmissionSuccess");
		return model;
	}
	

}
