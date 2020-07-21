package com.yaswanth.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;



public class SpringAPP {
     public static void main(String[] args) {
		//BeanFactory beanFactory = new ClassPathXmlApplicationContext(("bean.xml"));
    	ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
		Triangle traingle=(Triangle) context.getBean("traingle");
		traingle.draw();
	}
}
