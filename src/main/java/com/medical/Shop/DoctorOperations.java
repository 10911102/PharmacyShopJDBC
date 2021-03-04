package com.medical.Shop;

import java.sql.SQLException;
import java.util.List;

import com.medical.DAO.IDoctorDAO;
import com.medical.Pharmacy.Doctor;

public class DoctorOperations {
	private IDoctorDAO doctorDAO;

	public IDoctorDAO getDoctorDAO() {
		return doctorDAO;
	}
	public void setDoctorDAO(IDoctorDAO doctorDAO) {
		this.doctorDAO = doctorDAO;
	}
	/**
	 * Search name of doctor from list. may be first name or last name of the doctor.
	 * @param name The String to search in Doctor List
	 * @return doctor object if it is present in list, if not then return null
	 */
	public List<Doctor> searchDoctor(String name){
		List<Doctor> list=doctorDAO.searchName(name);
		if(list==null)
			System.out.println("Try another Name!");
		return list;
	}
	public void showAllDoctors() throws SQLException {
		System.out.println("Doctor_Id        First_name       Last_name ");
		for (Doctor doctor : doctorDAO.getAll()) {
			System.out.println(doctor.getId()+"   "+doctor.getfName()+"    "+doctor.getlName());
		}
	}

}
