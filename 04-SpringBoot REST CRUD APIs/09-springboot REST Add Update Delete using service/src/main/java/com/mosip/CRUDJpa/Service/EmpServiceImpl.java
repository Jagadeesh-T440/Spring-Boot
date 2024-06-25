package com.mosip.CRUDJpa.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mosip.CRUDJpa.DAO.DAO;
import com.mosip.CRUDJpa.Entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmpServiceImpl implements EmpService{

	private DAO Dao;
	
	public EmpServiceImpl(DAO theDao) {
		Dao=theDao;
	}

	@Override
	public List<Employee> findAll() {
		
		return Dao.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return Dao.findById(theId);
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		return Dao.save(theEmployee);
	}

	@Transactional
	@Override
	public void deletyById(int theId) {
		
		Dao.deletyById(theId);
	}
	
}
