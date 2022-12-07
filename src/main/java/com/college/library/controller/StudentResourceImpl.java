package com.college.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.library.domain.Student;
import com.college.library.repositories.StudentRepository;
import com.college.library.service.StudentService;



@RestController
@RequestMapping("/student")
public class StudentResourceImpl implements StudentResource {

	@Autowired
	StudentService studentService;
	
	@Override
	public ResponseEntity<String> saveStudent(Student student) {
		return new ResponseEntity<String>(studentService.saveStudent(student), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getStudentById(String studentUSN) {
		return new ResponseEntity<Object>(studentService.getStudentById(studentUSN),HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<Object> updateStudentById(String studentUSN, Student student) {
		return new ResponseEntity<Object>(studentService.updateStudent(studentUSN,student), HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<Object> deleteStudentById(String studentId) {
		return new ResponseEntity<Object>(studentService.deleteStudent(studentId), HttpStatus.OK);
	}

}
