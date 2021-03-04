package com.medical.Shop;

import java.util.List;
import java.util.Scanner;

import com.medical.DAO.IMedicineDAO;
import com.medical.DAO.IPharmacyDAO;
import com.medical.Pharmacy.Medicine;
import com.medical.Pharmacy.Pharmacy;

public class ShopOperations {
		
	private IMedicineDAO medicineDAO;
	private IPharmacyDAO pharmacyDAO;
	private OrderOperations orderOperation;
	Scanner sc = new Scanner(System.in);

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

	public OrderOperations getOrderOperation() {
		return orderOperation;
	}

	public void setOrderOperation(OrderOperations orderOperation) {
		this.orderOperation = orderOperation;
	}

	/**
	 * Prints the list of medicine with there quantity available in pharmacy store
	 */
	public void showAllMedicine() {
		Medicine medicine;
		System.out.println("Medicine_Id         Name        Brand      Qauntity");
		for (Pharmacy pharmacy : pharmacyDAO.getAll()) {
			medicine =medicineDAO.getById(pharmacy.getMedicineId());
			System.out.println(pharmacy.getId() + "  " + medicine.getName() + "   "+medicine.getBrand()+"   " + pharmacy.getQuantity());
		}
	}

	/**
	 * Search the medicine name or brand available in store
	 * 
	 * @param medicine String medicine name or brand
	 * @return if found then returns the object otherwise returns null with message
	 *         on console.
	 */
	public List<Medicine> searchMedicine(String medicine) {
		List<Medicine> list = medicineDAO.searchMedicine(medicine);
		return list;
	}

	/**
	 * To Sell medicine to customer when he visits the store.
	 */
	public void sellMedicine() {
		showAllMedicine();
		System.out.println("Enter Medicine_Id to sell medicine");
		int id = sc.nextInt();
		sc.nextLine();
		Pharmacy pharmacy=pharmacyDAO.getById(id);
		System.out.println("Enter quantity");
		int quantity = sc.nextInt();
		checkStock(pharmacy, quantity);
		System.out.println("Order Placed for " + medicineDAO.getById(id) + " " + quantity);
		System.out.println("Enter any number to continue or 0 to end order");
		int choice = sc.nextInt();
		if (choice != 0) {
			sellMedicine();
		}
	}

	/**
	 * To Check the stock that parameterized medicine is available or not before
	 * selling them. warns the shopkeeper if stock is less then 25.
	 * 
	 * @param pharmacy that contains medicine details and quantity available in
	 *                 stock.
	 * @param quantity number of medicine required by customer
	 */
	public void checkStock(Pharmacy pharmacy, int quantity) {
		if (pharmacy.getQuantity() > quantity) {
			pharmacyDAO.setQuantity(pharmacy,(pharmacy.getQuantity() - quantity));
			if ((pharmacy.getQuantity() - 20) < quantity) {
				System.out.println("Stock running out. pls order stock");
			}
		} else {
			System.out.println("Shortage in Stock.Tell to visit again");
			System.out.println("Enter Quantity of medicine " + pharmacy.getMedicineId() + " to place order");
			quantity = sc.nextInt();
			orderOperation.placeOrder(pharmacy, quantity);
		}
	}

	
}
