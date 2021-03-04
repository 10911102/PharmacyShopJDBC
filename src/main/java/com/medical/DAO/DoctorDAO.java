package com.medical.DAO;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.medical.Pharmacy.Doctor;
import com.medical.RowMapper.DoctorMapper;

public class DoctorDAO  implements IDoctorDAO{
	private JdbcTemplate jdbcTemplate;
	DataSource dataSource;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Doctor> getAll() throws SQLException {
		 return this.jdbcTemplate.query("Select * from Doctor",new DoctorMapper());
		}


	public List<Doctor> searchName(String name) {
		String query = "select * from doctor where fname like '%"+name+"%' or lname like '%"+name+"%'";
		List<Doctor> doctors = jdbcTemplate.query(query, new DoctorMapper());
		return doctors;
	}


	

}
