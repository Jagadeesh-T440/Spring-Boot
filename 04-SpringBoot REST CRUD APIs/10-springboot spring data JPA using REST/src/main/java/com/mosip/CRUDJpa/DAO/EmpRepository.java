package com.mosip.CRUDJpa.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mosip.CRUDJpa.Entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{
	
	//no need any code

}
