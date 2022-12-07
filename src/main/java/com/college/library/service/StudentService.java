package com.college.library.service;


import java.util.List;
import com.college.library.domain.Student;

public interface StudentService {
	String saveStudent(Student student);
	Object deleteStudent(String studentId);
	List<Student> getAllStudents();
	Object getStudentById(String studentUSN);
	Object updateStudent(String studentUSN, Student student);  

}
