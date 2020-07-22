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
import org.springframework.stereotype.Component;

import com.yaswanth.model.Example;

@Component
public class Exampledao {
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	

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
	}

	Connection con  = null;
	PreparedStatement pst;

	

	public Example getExample(int id) {
		
		Example example = null;
		try {
			con = dataSource.getConnection();
			String cmd = "select * from example where id=?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				example = new Example(id, rs.getString("name"));
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return example;

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
		String cmd = "insert into example (id , name) values (?,?)";
		jdbcTemplate.update(cmd, new Object[] {eml.getId(),eml.getName()});
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
