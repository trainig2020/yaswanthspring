package com.yaswanth.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayBasedInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 Calendar cal = Calendar.getInstance();
		 
		 int dayofweek = cal.get(cal.DAY_OF_WEEK);
		 
		 if(dayofweek == 1) {
			 response.getWriter().write("This website will wont work on Sunday try on week days");
			 
			 return false;
		 }
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("Spring Mvc made a call to postHandle method for:"+request.getRequestURI().toString());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("Spring Mvc made a call to afterCompletion method for:"+request.getRequestURI().toString());
		
	}
	
	
	

}
