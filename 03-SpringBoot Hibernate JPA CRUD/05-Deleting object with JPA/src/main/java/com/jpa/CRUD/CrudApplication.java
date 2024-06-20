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
			
  		    //createMultipleStudents(studentDAO);
  		    
  		    //readStudent(studentDAO);
			
			//queryForStudents(studentDAO);
			
			//updateStudent(studentDAO);
			
			//deleteStudent(studentDAO);
			
			deleteAll(studentDAO);
			
		};
	}
	
	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleted All Students");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("Delete Count: "+numRowsDeleted);	
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int StudtId=1;
		System.out.println("Deleting Student id: "+ StudtId);
		studentDAO.delete(StudtId);
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studID=3;
		System.out.println("Getting Student id: "+studID);
		
		Student myStudent=studentDAO.findById(studID);
		
		System.out.println("Updating Students...");
		
		myStudent.setFirstName("Deives");
		studentDAO.update(myStudent);
		
		System.out.println(myStudent);
		
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findAll();
		for(Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		Student tempStudent1=new Student("jaga","thiygau","jaga40@TF.co.in","technoforte,");
		Student tempStudent2=new Student("karthik","suresh","shibaktk@TF.co.in","spaceX");
		Student tempStudent3=new Student("krithik","Balaji","krithik@TF.co.in","Accenture");
		Student tempStudent4=new Student("dharani","dharan","dharani@TF.co.in","google");
		
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
		
//		//create the student object
//   	    System.out.println("Creating new Student Details :)");
//		Student tempStudent=new Student("Jagadeesh","Thiyagarajan","jaga440@TF.co.in");
//		
//		//save the student object
//        System.out.println("Saving the student Object :)");
//		studentDAO.save(tempStudent);
		//int temp=tempStudent.getId();
		int temp=3;
		
		//retrive student id
		System.out.println("Retrieving Students id: "+temp);
		
		Student myStudent=studentDAO.findById(temp);
		
		System.out.println("Found Student : "+myStudent);
	}
}