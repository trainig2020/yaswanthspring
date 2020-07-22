package com.yaswanth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yaswanth.model.Example;

@Component
public class Exampledao {
	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
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
			return example;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return example;

	}
}
