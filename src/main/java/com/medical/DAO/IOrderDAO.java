package com.medical.DAO;

import java.util.List;

import com.medical.Pharmacy.Order;

public interface IOrderDAO {
	public List<Order> getAll();
	public List<Order> getAllPending();
	public Order getById(int id);
	public int updateOrderStatus(int id);
	public int insertOrder(Order order);
}
