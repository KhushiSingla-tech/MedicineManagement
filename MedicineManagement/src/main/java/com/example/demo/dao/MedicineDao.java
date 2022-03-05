package com.example.demo.dao;

import com.example.demo.entity.Medicine;
import java.util.List;

public interface MedicineDao {
	
	public String addMedicine(Medicine m);
	public String deleteMedicine(int id);
	public Medicine searchMedicine(int id);
	public String updateMedicine(Medicine m);
	public List<Medicine> selectall();

}
