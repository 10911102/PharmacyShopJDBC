package com.medical.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.medical.Pharmacy.Order;
import com.medical.RowMapper.OrderMapper;

public class OrderDAO implements IOrderDAO {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Order> getAll() {
		return jdbcTemplate.query("select * from Order_stock", new OrderMapper());
	}

	public List<Order> getAllPending() {
		return jdbcTemplate.query("select * from Order_stock where Delivery_status= 'Not received'", new OrderMapper());
	}

	public Order getById(int id) {
		String query = "select * from Order_stock where id =?";
		RowMapper<Order> rowMapper = new OrderMapper();
		return jdbcTemplate.queryForObject(query, rowMapper, id);
	}

	public int updateOrderStatus(int id) {
		String query = "update Order_stock set Delivery_status = 'Deliverd' where id ="+id+" ";
		return jdbcTemplate.update(query);
	}

	public int insertOrder(Order order) {
		String query = "insert into Order_stock(id, Medicine_id, Quantity, Delivery_status) values(?,?,?,?)";
		return jdbcTemplate.update(query, order.getId(), order.getMedicineId(), order.getQuantity(),
				order.getStatus());
	}

}
