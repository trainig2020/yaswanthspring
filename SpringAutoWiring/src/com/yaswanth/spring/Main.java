package com.yaswanth.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
		Traingle traingle = (Traingle) context.getBean("traingle");
		traingle.draw();

	}
}
