package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Medicine;

@Repository
public class MedicineDaoImpl implements MedicineDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addMedicine(Medicine m) throws DataAccessException {
		
		Medicine midi = searchMedicine(m.getId());
		
		if(midi == null)
		{
			int rowCount = jdbcTemplate.update("insert into medicinerepo values('"+m.getId()+"','"+m.getName()+"','"+m.getCount()+"','"+m.getDescription()+"')");
			if(rowCount == 1)
			{
				return "success";
			}
			else
			{
				return "existed";
			}
		}
		else
		{
			return "existed";
		}

	}

	@Override
	public String deleteMedicine(int id) {
			String SQL = "delete from medicinerepo where id = ?";
		    int rowCount = jdbcTemplate.update(SQL, id);
			if(rowCount == 1)
			{
				return "success";
			}
			else
			{
				return "existed";
			}
	}

	@Override
	public Medicine searchMedicine(int id) {
		
		Medicine md;
		
		List<Medicine> medList = jdbcTemplate.query("select * from medicinerepo where Id='"+id+"'", (rs,rowCount) -> {
			
			Medicine m=new Medicine();
			m.setId(Integer.parseInt(rs.getString("ID")));
			m.setName(rs.getString("NAME"));
			m.setCount(Integer.parseInt(rs.getString("COUNT")));
			m.setDescription(rs.getString("DESCRIPTION"));
			return m;
			
		});
		
		if(medList.isEmpty() == true)
		{
			md = null;
		}
		else
		{
			return md = medList.get(0);
		}
		
		return md;
	}

	@Override
	public String updateMedicine(Medicine m) {
			int rowCount = jdbcTemplate.update("update medicinerepo set ID='"+m.getId()+"',Name='"+m.getName()+"',Count='"+m.getCount()+"',Description='"+m.getDescription()+"' where ID='"+m.getId()+"'");
			if(rowCount == 1)
			{
				return "success";
			}
			else
			{
				return "existed";
			}
	}

	@Override
	public List<Medicine> selectall() {
		
		List<Medicine> medi = new ArrayList();
		
		List<Medicine> medList = jdbcTemplate.query("select * from medicinerepo", (rs,rowCount) -> {
			
			Medicine m=new Medicine();
			m.setId(Integer.parseInt(rs.getString("ID")));
			m.setName(rs.getString("NAME"));
			m.setCount(Integer.parseInt(rs.getString("COUNT")));
			m.setDescription(rs.getString("DESCRIPTION"));
			
			medi.add(m);
			return m;
			
		});
		
		return medi;
		
	}

}
