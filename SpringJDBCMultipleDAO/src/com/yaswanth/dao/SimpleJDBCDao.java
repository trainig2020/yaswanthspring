package com.yaswanth.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SimpleJDBCDao extends SimpleJdbcDaoSupport {
     
	
	public int getExampleCount() {
		String cmd= "select COUNT(*) from example";
		return this.getJdbcTemplate().queryForInt(cmd);
	}
}
