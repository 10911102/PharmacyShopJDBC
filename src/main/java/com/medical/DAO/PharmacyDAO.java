package com.medical.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.medical.Pharmacy.Pharmacy;
import com.medical.RowMapper.PharmacyMapper;

public class PharmacyDAO implements IPharmacyDAO {
private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Pharmacy> getAll() {
		return jdbcTemplate.query("select * from pharmacy", new PharmacyMapper());
	}

	public Pharmacy getById(int medicineId) {
		String query = "select * from pharmacy where Medicine_id =?";
		RowMapper<Pharmacy> rowMapper = new PharmacyMapper();
		return jdbcTemplate.queryForObject(query, rowMapper, medicineId);
	}
	public int setQuantity(Pharmacy pharmacy, int quantity) {
		String query = "update Pharmacy set Qauntity = "+quantity+" where id ="+pharmacy.getId()+" ";
		return jdbcTemplate.update(query);
	}

}
