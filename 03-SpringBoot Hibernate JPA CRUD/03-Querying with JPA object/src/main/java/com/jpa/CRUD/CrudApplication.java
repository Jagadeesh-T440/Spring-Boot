package com.jpa.CRUD;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.CRUD.DAO.StudentDAO;
import com.jpa.CRUD.Entity.Student;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return runner->{
			//readStudent(studentDAO);
//			createStudent(studentDAO);
//  		createMultipleStudents(studentDAO);
			//queryForStudents(studentDAO);
			queryByLastName(studentDAO);
			
		};
	}



	private void queryByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student> theStudents=studentDAO.findByLastName("suresh");
		for(Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
		
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		List<Student> theStudents=studentDAO.findAll();
		for(Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student tempStudent1=new Student("Jaga","Thiyagu","jaga440@Tf.co.in");
		Student tempStudent2=new Student("karthik","suresh","shibaktk@TF.co.in");
		Student tempStudent3=new Student("krithik","Balaji","krithik@TF.co.in");
		Student tempStudent4=new Student("dharani","dharan","dharani@TF.co.in");
		
		
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		
		
		System.out.println("Saved Student_id Details: "+tempStudent1.getId());
		System.out.println("Saved Student_id Details: "+tempStudent2.getId());
		System.out.println("Saved Student_id Details: "+tempStudent3.getId());
		System.out.println("Saved Student_id Details: "+tempStudent4.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		
		//create the student object
   	    System.out.println("Creating new Student Details :)");
		Student tempStudent=new Student("Jagadeesh","Thiyagarajan","jaga440@gamil.com");
		
		//save the student object
        System.out.println("Saving the student Object :)");
		studentDAO.save(tempStudent);
		
		//display id of the student object
		System.out.println("Saved Student_id Details: "+tempStudent.getId());
		
		//retrive student id
		System.out.println("Retrieving Students id: "+tempStudent.getId());
		
		Student myStudent=studentDAO.finfById(tempStudent.getId());
		
		System.out.println("Found Student : "+myStudent);
	}
}

