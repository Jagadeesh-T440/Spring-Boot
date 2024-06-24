package com.mosip.crud.REST.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mosip.crud.REST.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class RPOJO {

	public List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		
		theStudents=new ArrayList<>();
		
		theStudents.add(new Student("Jaga", "thiyagu", 21, "jaga@TF.co.in"));
		theStudents.add(new Student("karthik", "suresh", 20, "ktk@TF.co.in"));
		theStudents.add(new Student("charan", "kumar", 21, "charan@TF.co.in"));
		theStudents.add(new Student("krithik", "balaji", 22, "krithik@TF.co.in"));
		
	}
	@GetMapping("/student")
	public List<Student> getStud(){
		 
		return theStudents;
	}

	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if(studentId>=theStudents.size()||studentId<0) {
			throw new StudentNotFoundException("Student id not found - "+studentId);
		}
		
		return theStudents.get(studentId);
		
	}
	
}
