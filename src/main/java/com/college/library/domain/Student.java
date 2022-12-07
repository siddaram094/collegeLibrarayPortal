package com.college.library.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String studentUSN;
	private String studentFName;
	private String studentLName;
	private String studentEmail;
	private String studentPhNo;
	private String sem;
	private String branch;
	
}
