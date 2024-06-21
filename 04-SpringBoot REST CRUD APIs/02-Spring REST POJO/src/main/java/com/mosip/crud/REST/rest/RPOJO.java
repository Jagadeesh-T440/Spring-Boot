package com.mosip.crud.REST.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mosip.crud.REST.entity.Student;

@RestController
@RequestMapping("/api")
public class RPOJO {

	@GetMapping("/student")
	public List<Student> getStud(){
		
		List<Student> theStudents=new ArrayList<>();
		theStudents.add(new Student("Jaga", "thiyagu", 21, "jaga@TF.co.in"));
		theStudents.add(new Student("karthik", "suresh", 20, "ktk@TF.co.in"));
		theStudents.add(new Student("charan", "kumar", 21, "charan@TF.co.in"));
		theStudents.add(new Student("krithik", "balaji", 22, "krithik@TF.co.in"));
		
		return theStudents;
	}
}
