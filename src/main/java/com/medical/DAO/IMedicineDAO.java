package com.medical.DAO;

import java.util.List;

import com.medical.Pharmacy.Medicine;

public interface IMedicineDAO {
	public List<Medicine> getAll();
	public List<Medicine> searchMedicine(String name);
	public Medicine getById(int medicineId);

}
