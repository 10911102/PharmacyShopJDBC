package com.medical.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.Pharmacy.Pharmacy;

public class PharmacyMapper implements RowMapper<Pharmacy> {

	public Pharmacy mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pharmacy pharmacy=new Pharmacy();
		pharmacy.setId(rs.getInt(1));
		pharmacy.setMedicineId(rs.getInt(2));
		pharmacy.setQuantity(rs.getInt(3));
		return pharmacy;
	}

}
