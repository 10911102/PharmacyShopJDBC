package com.medical.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.Pharmacy.Doctor;

public class DoctorMapper implements RowMapper<Doctor> {
	
		public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Doctor doctor = new Doctor();
			doctor.setId(rs.getInt(1));
			doctor.setfName(rs.getString(2));
			doctor.setlName(rs.getString(3));
			return doctor;
		
	}
}
