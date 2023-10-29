package com.StudentManagement.Management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentManagement.Management.Entity.Student;


public interface StudentRepo extends JpaRepository<Student, Integer> {

}
