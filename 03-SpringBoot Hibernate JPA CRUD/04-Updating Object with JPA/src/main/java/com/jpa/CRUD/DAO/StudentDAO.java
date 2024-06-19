package com.jpa.CRUD.DAO;

import java.util.List;

import com.jpa.CRUD.Entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	Student finfById(Integer id);
	List<Student> findAll();
	List<Student> findByLastName(String theLastName);
	void update(Student theStudent );
	
}
