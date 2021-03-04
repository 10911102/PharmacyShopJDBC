package com.medical.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.medical.Pharmacy.Order;

public class OrderMapper implements RowMapper<Order> {

	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order order = new Order();
		order.setId(rs.getInt(1));
		order.setMedicineId(rs.getInt(2));
		order.setQuantity(rs.getInt(3));
		order.setStatus(rs.getString(4));
		return order;
	}
	

}
