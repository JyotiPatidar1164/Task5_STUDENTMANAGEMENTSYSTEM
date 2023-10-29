package com.StudentManagement.Management.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.StudentManagement.Management.Entity.Student;
import com.StudentManagement.Management.Service.Service1;

@RestController

public class StudentManagement {
	@Autowired
	private Service1 ser;
	
	@GetMapping("/get")
	public List<Student> getStudent()
	{
		List<Student> list= ser.getAllStudents();
		return list;
	}
	
	@GetMapping("/get/{id}")
	public Student findByStudentId(@PathVariable("id")int id)
	{
		Student student = ser.getStudentById(id);
		return student;
		
	}
    @PostMapping("/post")
    public String setStudent(@RequestBody Student student)
   {
	String response=ser.setStudent(student);
	return response;
	}
    
    @DeleteMapping("/deleteStudent/{id}")
    public String deleteById(@PathVariable("id") int id)
    {
    	String s=ser.deleteById(id);
    	return s;
    }
    
    @PutMapping("put/{id}")
    public String updateStudent(@PathVariable("id") int id, @RequestBody Student student)
    {
    	String s = ser.updateStudent(id,student);
    	
		return s;
    	
    }
    
    
    
    
	
	
	
	

}
