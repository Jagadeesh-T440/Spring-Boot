package com.mosip.CRUDJpa.DAO;

import java.util.List;

import com.mosip.CRUDJpa.Entity.Employee;

public interface DAO {
	
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deletyById(int theId);

}
