package com.medical.DAO;

import java.sql.SQLException;
import java.util.List;

import com.medical.Pharmacy.Doctor;

public interface IDoctorDAO {
	public List<Doctor> getAll()throws SQLException;
	public List<Doctor> searchName(String name);

}
