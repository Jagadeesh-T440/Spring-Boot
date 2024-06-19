package com.jpa.CRUD.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.CRUD.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImp implements StudentDAO {
	
	//define the fields
	private EntityManager entityManager;

	//Inject the entitymanager
	
	@Autowired
	public StudentDAOImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	// save the java object 
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student finfById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery =entityManager.createQuery("FROM Student",Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName (String theLastName) {
		TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
		theQuery.setParameter("theData", theLastName);
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
	}

	
}
