package com.medical.Pharmacy;

public class Pharmacy {
	private int id;
	private int medicineId;
	private int quantity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Pharmacy id=" + id + ", medicineId=" + medicineId + ", quantity=" + quantity + "";
	}
	

}
