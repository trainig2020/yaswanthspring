package com.yaswanth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.yaswanth.model.Example;

@Component
public class Exampledaonew   {
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public int getExampleCount() {
		String cmd= "select COUNT(*) from example";
		//jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate.queryForInt(cmd);
	}
	
	public String getExampleName(int id) {
		String cmd = "select name from example where id=?";
		return jdbcTemplate.queryForObject(cmd, new Object[] { id }, String.class);
	}
	
	public Example getExampleForId(int id) {
		String cmd = "select * from Example where id = ?";
		return jdbcTemplate.queryForObject(cmd, new Object[] {id}, new ExampleMapper());
	}
	public List<Example> getAllExamples(){
		String cmd = "select * from Example";
		return jdbcTemplate.query(cmd, new ExampleMapper());
	}
	
	public void insertExample(Example eml) {
		String cmd = "insert into example (id , name) values (:id, :name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",eml.getId()).addValue("name", eml.getName()); 
		namedParameterJdbcTemplate.update(cmd, namedParameters);
	}
	
	public void deleteExample(int id) {
		String cmd = "delete from example where id=?";
		jdbcTemplate.update(cmd, new Object[] { id});
	}
	
	
	private static final class ExampleMapper implements RowMapper<Example>{

		@Override
		public Example mapRow(ResultSet rs, int rowNum) throws SQLException {
			Example example =new Example();
			example.setId(rs.getInt("id"));
			example.setName(rs.getString("name"));
			return example;
		}
		
	}
}
