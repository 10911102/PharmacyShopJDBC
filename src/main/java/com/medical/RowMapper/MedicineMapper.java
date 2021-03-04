package com.medical.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.Pharmacy.Medicine;

public class MedicineMapper implements RowMapper<Medicine> {

	public Medicine mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Medicine medicine = new Medicine();
		medicine.setId(rs.getInt(1));
		medicine.setName(rs.getString(2));
		medicine.setBrand(rs.getString(3));
		return medicine;
	}

}
