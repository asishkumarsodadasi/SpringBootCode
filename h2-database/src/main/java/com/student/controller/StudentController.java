package com.student.controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import com.student.data.Student;  
import com.student.services.StudentServices;  

@RestController
public class StudentController {
	
	@Autowired  
	StudentServices studentservice;
	
	@GetMapping("/student")  
	private List<Student> getAllStudent()   
	{  
	return studentservice.getAllStudent();  
	}  
	
	@GetMapping("/student/{id}")  
	private Student getStudent(@PathVariable("id") int id)   
	{  
	return studentservice.getStudentById(id);  
	}  

	@DeleteMapping("/student/{id}")  
	private void deleteStudent(@PathVariable("id") int id)   
	{  
		studentservice.delete(id);  
	}  

	@PostMapping("/uploadstudent")  
	private int saveStudent(@RequestBody Student student)   
	{  
		studentservice.saveOrUpdate(student);  
		return student.getId();  
	} 
}
	
