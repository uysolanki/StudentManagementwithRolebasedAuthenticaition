package com.greatlearning.University.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.University.entity.Student;
import com.greatlearning.University.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studrepo;
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studrepo.findAll();
	}
 
	@Override
	public Student findById(int studId) {
		// TODO Auto-generated method stub
		return studrepo.findById(studId).get();
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studrepo.save(student);
	}

	@Override
	public void deleteById(int studId) {
		studrepo.deleteById(studId);
	}

}
