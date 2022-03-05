package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Medicine;
import com.example.demo.services.MedicineServices;

@Controller
public class MedicineController {
	
	@Autowired
	MedicineServices mediService;
	
	@RequestMapping("/home")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/services")
	public String service()
	{
		return "services";
	}
	
	@RequestMapping("/addpage")
	public String addpage()
	{
		return "addpage";
	}
	
	@RequestMapping("/updatepage")
	public String updatepage()
	{
		return "updatepage";
	}

	@RequestMapping("/deletepage")
	public String deletepage()
	{
		return "deletepage";
	}
	
	@RequestMapping("/showpage")
	public String showpage()
	{
		return "showpage";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam String id, @RequestParam String name, @RequestParam String count, @RequestParam String des)
	{
		Medicine medi = new Medicine();
		medi.setId(Integer.parseInt(id));
		medi.setName(name);
		medi.setCount(Integer.parseInt(count));
		medi.setDescription(des);
		
		String status = mediService.Add(medi);
		
		return status;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String id)
	{
		String status = mediService.Delete(Integer.parseInt(id));
		
		return status;
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam String id, @RequestParam String name, @RequestParam String count, @RequestParam String des)
	{
		Medicine medi = new Medicine();
		medi.setId(Integer.parseInt(id));
		medi.setName(name);
		medi.setCount(Integer.parseInt(count));
		medi.setDescription(des);
		
		String status = mediService.Update(medi);
		
		return status;
	}
	
}
