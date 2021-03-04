package com.medical.DAO;

import java.util.List;

import com.medical.Pharmacy.Pharmacy;

public interface IPharmacyDAO {
	public List<Pharmacy> getAll();
	public Pharmacy getById(int medicineId);
	public int setQuantity(Pharmacy pharmacy, int quantity);
	

}
