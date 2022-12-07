package com.college.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.library.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	Student findByStudentUSN(String usn);
	

}
