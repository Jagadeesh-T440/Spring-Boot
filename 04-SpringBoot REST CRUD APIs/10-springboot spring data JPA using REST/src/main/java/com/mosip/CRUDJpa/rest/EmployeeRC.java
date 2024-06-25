package com.mosip.CRUDJpa.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);  // this is to force a new item .....instead of update
		Employee dbEmployee = empService.save(theEmployee);
		return dbEmployee;
	}
	
	@PutMapping("/putemployee")
	public Employee putEmployee(@RequestBody Employee theEmployee) {
		
		int id=theEmployee.getId();
		Employee dbEmployee=empService.findById(id);
		
		if(dbEmployee==null) {
			throw new RuntimeException("Employee id not found - "+ id);
		}
		Employee employee = empService.save(theEmployee);
		return employee;
	}
	
	@DeleteMapping("/delemployee/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee =empService.findById(employeeId);
		
		if(theEmployee==null) {
			throw new RuntimeException("Employee id not found - "+ employeeId);
		}
		empService.deletyById(employeeId);
		
		return "Deleted id - "+employeeId;
		
	}
	
	
}
