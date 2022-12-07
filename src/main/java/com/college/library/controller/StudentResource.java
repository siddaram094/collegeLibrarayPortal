package com.college.library.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.library.domain.Student;

@RestController("/student")
public interface StudentResource {

	@PostMapping("/savestudent")
	public ResponseEntity<String> saveStudent(@RequestBody Student student);
	
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getAllStudents();
	
	@GetMapping("/getStudents/{studentUSN}")
	public ResponseEntity<Object> getStudentById(@PathVariable("studentUSN") String studentUSN);
	
	@PutMapping("/updateStudents/{studentUSN}")
	public ResponseEntity<Object> updateStudentById(@PathVariable("studentUSN") String studentUSN,@RequestBody Student student);
	
	@DeleteMapping("/deleteStudent/{studentUSN}")
	public ResponseEntity<Object> deleteStudentById(@PathVariable("studentUSN") String studentUSN);

}
