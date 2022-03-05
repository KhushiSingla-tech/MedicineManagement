package com.example.demo.services;

import com.example.demo.entity.Medicine;
import java.util.List;

public interface MedicineServices {

	public String Add(Medicine m);
	public String Delete(int id);
	public String Update(Medicine m);
	public List<Medicine> Select();
	
}
