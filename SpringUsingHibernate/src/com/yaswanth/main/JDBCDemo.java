package com.yaswanth.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yaswanth.dao.Exampledao;
import com.yaswanth.dao.Hibernatedao;
import com.yaswanth.model.Example;

public class JDBCDemo {
     public static void main(String[] args) {
    	 
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    	Exampledao dao = (Exampledao) applicationContext.getBean("exampledao");
    	
    	Hibernatedao hibernatedao = (Hibernatedao) applicationContext.getBean("hibernatedao");
    	
//		Example  example = dao.getExample(1);
//		System.out.println(example.getName());
		
		System.out.println(dao.getExampleCount());
		
		System.out.println(dao.getExampleName(2));
		
		System.out.println(dao.getExampleForId(1).getName());
		
		
		// insereting the record into table using jdbctemplate
		
		//dao.insertExample(new Example(3,"Rama"));
		
		
		System.out.println(dao.getAllExamples().toString());
		
		// insereting the record into table using namedparameterjdbctemplate
		
		dao.insertExample(new Example(4,"SaiRam"));
		
		dao.deleteExample(3);
		
		System.out.println(dao.getAllExamples().toString());
    	 System.out.println(hibernatedao.getExampleCount());
    	
	}
}
