package com.mosip.CRUDJpa.Service;

import java.util.List;

import com.mosip.CRUDJpa.Entity.Employee;

public interface EmpService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deletyById(int theId);


	
}
