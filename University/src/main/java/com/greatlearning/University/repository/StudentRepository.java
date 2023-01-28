package com.greatlearning.University.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.University.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
