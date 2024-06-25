package com.mosip.CRUDJpa.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mosip.CRUDJpa.Entity.Employee;
import com.mosip.CRUDJpa.Service.EmpService;


@RestController
@RequestMapping("/api")
public class EmployeeRC {

	private EmpService empService;
	
	public EmployeeRC(EmpService theEmpService) {
		empService=theEmpService;
	}
	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		
		return empService.findAll();
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId ) {
		
		Employee theEmployee=empService.findById(employeeId);
		if(theEmployee==null) {
			throw new RuntimeException("Employee id not found - "+ employeeId);
		}
		
		return theEmployee;
		
	}
	
}
