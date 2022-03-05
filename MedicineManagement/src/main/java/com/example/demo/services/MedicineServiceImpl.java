package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MedicineDao;
import com.example.demo.entity.Medicine;

@Service
public class MedicineServiceImpl implements MedicineServices {
	
	@Autowired
	MedicineDao mediDao;

	@Override
	public String Add(Medicine m) {
		
		String status = mediDao.addMedicine(m);
		
		return status;
	}

	@Override
	public String Delete(int id) {
		String status = mediDao.deleteMedicine(id);
		
		return status;
	}

	@Override
	public String Update(Medicine m) {
		String status = mediDao.updateMedicine(m);
		
		return status;
	}

}
