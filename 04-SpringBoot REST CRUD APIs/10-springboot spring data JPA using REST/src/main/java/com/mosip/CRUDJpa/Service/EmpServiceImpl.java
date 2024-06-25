package com.mosip.CRUDJpa.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.mosip.CRUDJpa.DAO.EmpRepository;
import com.mosip.CRUDJpa.Entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmpServiceImpl implements EmpService{

	private EmpRepository empRepository;
	
	public EmpServiceImpl(EmpRepository theEmpRepository) {
		empRepository=theEmpRepository;
	}

	@Override
	public List<Employee> findAll() {
		
		return empRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result=empRepository.findById(theId);
		
		//Employee theEmployee=null;
		
		if(result.isPresent()) {
			return result.get();
		}
		else {
			throw new RuntimeException("Didn't find emp_id - "+theId);
		}
		
	}

	@Override
	public Employee save(Employee theEmployee) {
		return empRepository.save(theEmployee);
	}

	@Override
	public void deletyById(int theId) {
		
		empRepository.deleteById(theId);
	}
	
}
