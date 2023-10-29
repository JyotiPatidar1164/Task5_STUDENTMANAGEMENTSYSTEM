package com.StudentManagement.Management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.Management.Entity.Student;
import com.StudentManagement.Management.Repo.StudentRepo;
@Service
public class Service1 {
   @Autowired
	private StudentRepo studentRepo;
	
	  public List<Student> getAllStudents() {
	        return studentRepo.findAll();
	    }

	public String setStudent(Student student) {
		// TODO Auto-generated method stub
		 Student s1=studentRepo.saveAndFlush(student);
		 System.out.println(s1.getRoll_Number());
		return "Student Roll Number:"+s1.getRoll_Number();
	}
	  public Student getStudentById(Integer studentId) {
	        return studentRepo.findById(studentId).orElse(null);
	    }

	public String deleteById(int id) {
		
		Optional<Student> student=studentRepo.findById(id);
		System.out.println(student);
		if(student.isPresent())
		{
		studentRepo.deleteById(id);
    	return "data is delete which student id="+id;

		}
		else
		{
			return "Id not exist";
		}
	}

//	public Optional<Student> updateStudent(int id) {
//		 Optional<Student> student=	studentRepo.save(null)
//		return null;
//	}

	

//	public String updateStudent(int id, Student student) {
//		// TODO Auto-generated method stub
//		studentRepo.save(student);
//		return "data update";
//	}

	
	
	

	public String updateStudent(int id, Student student) {
	    Optional<Student> existingStudent = studentRepo.findById(id);

	    if (existingStudent.isPresent()) {
	        student.setRoll_Number(id);; // Set the ID to specify which student to update
	        studentRepo.save(student);
	        return "Data updated successfully";
	    } else {
	        return "Student with ID " + id + " not found"; // Handle the case where the student doesn't exist
	    }
	}


}
