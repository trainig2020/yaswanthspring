package com.yaswanth.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yaswanth.dao.Exampledao;
import com.yaswanth.model.Example;

public class JDBCDemo {
     public static void main(String[] args) {
    	 
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    	Exampledao dao = (Exampledao) applicationContext.getBean("exampledao");
		Example  example = dao.getExample(1);
		System.out.println(example.getName());
	}
}
