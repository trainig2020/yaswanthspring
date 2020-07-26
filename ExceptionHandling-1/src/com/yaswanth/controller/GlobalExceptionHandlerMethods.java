package com.yaswanth.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerMethods {
    
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e) {
		System.out.println("Null Pointer Exception Occured : " + e);

		return "NullPointerException";
	}

	@ExceptionHandler(value = IOException.class)
	public String handleIoException(Exception e) {
		System.out.println("IO Exception Occured : " + e);

		return "IoException";
	}

	@ExceptionHandler(value = Exception.class)
	public String handleGenericException(Exception e) {
		System.out.println("UnKnown Exception Occured : " + e);

		return "GenericException";
	}
}
