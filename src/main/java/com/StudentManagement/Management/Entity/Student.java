package com.StudentManagement.Management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roll_Number;
	private String name;
	private String course;
	private char grade;
	

}
