package com.medical.DAO;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.medical.Pharmacy.Medicine;
import com.medical.RowMapper.MedicineMapper;

public class MedicineDAO implements IMedicineDAO {
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Medicine> getAll() {
		List<Medicine> list=jdbcTemplate.query("Select * from Medicine", new MedicineMapper());
		return list;
	}

	public List<Medicine> searchMedicine(String name) {
		String query = "select * from medicine where name like '%"+name+"%' or brand like '%"+name+"%'";
		List<Medicine> list=jdbcTemplate.query(query, new MedicineMapper());
		return list;
	}

	public Medicine getById(int medicineId) {
		String query = "select * from medicine where id=?";
		RowMapper<Medicine> rowMapper = new MedicineMapper();
		return jdbcTemplate.queryForObject(query, rowMapper, medicineId);
	}
	

}
