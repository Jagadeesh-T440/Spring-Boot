package com.mosip.CRUDJpa.rest;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mosip.CRUDJpa.DAO.DAO;
import com.mosip.CRUDJpa.Entity.Employee;


@RestController
@RequestMapping("/api")
public class EmployeeRC {

	private DAO Dao;
	
	public EmployeeRC(DAO theDAO) {
		Dao=theDAO;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return Dao.findAll();
	}
}
