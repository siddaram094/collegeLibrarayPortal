package com.college.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.library.domain.Student;
import com.college.library.error.StudentException;
import com.college.library.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public String saveStudent(Student student) {
		if (studentRepository.findByStudentUSN(student.getStudentUSN())!=null) {
			throw new StudentException("student " + student.getStudentUSN() + "already exists");
		} else {
			studentRepository.save(student);
			return "student saved successfully";
		}
	}

	@Override
	public Object deleteStudent(String studentUSN) {
		Student student;
		if(studentRepository.findByStudentUSN(studentUSN)!=null) {
			student=studentRepository.findByStudentUSN(studentUSN);
		}else {
			throw new StudentException("Student USN  "+studentUSN +" is not valid");
		}
		studentRepository.deleteById(student.getId());
		return "Student with USN " +studentUSN +" deleted successfully ";
	}

	@Override
	public List<Student> getAllStudents() { 
		return studentRepository.findAll();
	}

	@Override
	public Object getStudentById(String studentUSN) {
		Student student;
		if(studentRepository.findByStudentUSN(studentUSN)!=null) {
			student=studentRepository.findByStudentUSN(studentUSN);
		}else {
			throw new StudentException("Student USN  "+studentUSN +" is not valid");
		}
		return student;
	}

	@Override
	public Object updateStudent(String studentUSN, Student student) {
		Student studentDB;
		if(studentRepository.findByStudentUSN(studentUSN)!=null) {
			studentDB=studentRepository.findByStudentUSN(studentUSN);
		}else {
			throw new StudentException("Student with "+studentUSN+" not exists");
		}
		if(null!=student.getSem() && student.getSem()!=" ") {
			studentDB.setSem(student.getSem());
		}
		if(null!=student.getStudentFName() && student.getStudentFName()!=" ") {
			studentDB.setStudentFName(student.getStudentFName());
		}
		if(null!=student.getStudentLName() && student.getStudentLName()!=" ") {
			studentDB.setStudentLName(student.getStudentLName());
		}
		if(null!=student.getStudentEmail() && student.getStudentEmail()!=" ") {
			studentDB.setStudentEmail(student.getStudentEmail());
		}
		if(null!=student.getStudentPhNo() && student.getStudentPhNo()!=" ") {
			studentDB.setStudentPhNo(student.getStudentPhNo());
		}
		if(null!=student.getBranch() && student.getBranch()!=" ") {
			studentDB.setBranch(student.getBranch());
		}
		studentRepository.save(studentDB);
		return "Student Details Updated";
	}
	
}
