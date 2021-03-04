package com.medical.Shop;

import java.util.List;

import com.medical.DAO.IMedicineDAO;
import com.medical.DAO.IOrderDAO;
import com.medical.DAO.IPharmacyDAO;
import com.medical.Pharmacy.Order;
import com.medical.Pharmacy.Pharmacy;

public class OrderOperations {
	private IOrderDAO orderDAO;
	private IMedicineDAO medicineDAO;
	private IPharmacyDAO pharmacyDAO;
	private ShopOperations shop;

	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public IMedicineDAO getMedicineDAO() {
		return medicineDAO;
	}

	public void setMedicineDAO(IMedicineDAO medicineDAO) {
		this.medicineDAO = medicineDAO;
	}

	public IPharmacyDAO getPharmacyDAO() {
		return pharmacyDAO;
	}

	public void setPharmacyDAO(IPharmacyDAO pharmacyDAO) {
		this.pharmacyDAO = pharmacyDAO;
	}

	public ShopOperations getShop() {
		return shop;
	}

	public void setShop(ShopOperations shop) {
		this.shop = shop;
	}

	/**
	 * Place order of required medicine in your store from warehouse or distributer
	 */
	public void placeOrder() {
		Order order = new Order();
		shop.showAllMedicine();
		System.out.println("Enter Medicine_Id to order medicine");
		int id = shop.sc.nextInt();
		shop.sc.nextLine();
		Pharmacy pharmacy = pharmacyDAO.getById(id);
		order.setMedicineId(pharmacy.getMedicineId());
		System.out.println("Enter Quantity of medicine to place order");
		int quantity = shop.sc.nextInt();
		order.setQuantity(quantity);
		order.setStatus("Not received");
		orderDAO.insertOrder(order);
		System.out.println("Order placed " + order);
	}

	/**
	 * Place order of parameterized medicine in your store from warehouse or
	 * distributer
	 * 
	 * @param pharmacy Object of Pharmacy class which contains medicine details.
	 * @param quantity Integer value of medicine required.
	 * @return Object of order class.
	 */
	public Order placeOrder(Pharmacy pharmacy, int quantity) {
		Order order = new Order();
		order.setMedicineId(pharmacy.getMedicineId());
		order.setQuantity(quantity);
		order.setStatus("Not received");
		orderDAO.insertOrder(order);
		return order;
	}

	/**
	 * Change the status of order when order get delivered and adds medicine in
	 * stock
	 */
	public void deliveryReport() {
		System.out.println("Enter order id to change delivery status");
		showAllOrder();
		int id = shop.sc.nextInt();
		Order order = orderDAO.getById(id);
		Pharmacy pharmacy = pharmacyDAO.getById(order.getMedicineId());
		pharmacyDAO.setQuantity(pharmacy,pharmacy.getQuantity() + order.getQuantity());
		orderDAO.updateOrderStatus(id);

	}

	/**
	 * Show All Oreders in store
	 */
	public void showAllOrder() {
		showOrders(orderDAO.getAll());
	}

	/**
	 * Shows all orders which are not delivered at store
	 */
	public void showPendingOrders() {
		showOrders(orderDAO.getAllPending());
	}

	/**
	 * prints the parameterized list of orders
	 * 
	 * @param orderList list of orders
	 */
	public void showOrders(List<Order> orderList) {
		System.out.println("Order_Id        Medicine_Name       Quantity      Status");
		for (Order order : orderList) {
			System.out.println(order.getId() + "    " + medicineDAO.getById(order.getMedicineId()).getName() + "     " + order.getQuantity() + "    "
					+ order.getStatus());
		}
	}

}
