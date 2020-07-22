package com.yaswanth.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public class Hibernatedao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public Object getExampleCount() {
		String cmd = "select count(*) from Example";
		Query query= getSessionFactory().openSession().createQuery(cmd);
		return query.uniqueResult();
	}
}
