package com.mosip.CRUDJpa.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mosip.CRUDJpa.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class DAOImpl implements DAO{
	
	private EntityManager entityManager;

	@Autowired
	public DAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee ",Employee.class);
		
		List<Employee> employees=theQuery.getResultList();
		
		return employees;
	}
	

}
