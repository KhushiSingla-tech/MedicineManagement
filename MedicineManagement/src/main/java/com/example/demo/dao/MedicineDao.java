package com.example.demo.dao;

import com.example.demo.entity.Medicine;

public interface MedicineDao {
	
	public String addMedicine(Medicine m);
	public String deleteMedicine(int id);
	public Medicine searchMedicine(int id);
	public String updateMedicine(Medicine m);

}
