package com.greatlearning.University.service;

import java.util.List;

import com.greatlearning.University.entity.Student;

public interface StudentService {

	List<Student> findAll();
	
	Student  findById(int studId);
	
	void save(Student student);
	
	void deleteById(int studId);
	
}
