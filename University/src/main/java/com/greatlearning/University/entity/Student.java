package com.greatlearning.University.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private int id;
		
		private String firstName;
		
		private String lastName;
		
		private String course;
		
		private String country;
		
}
