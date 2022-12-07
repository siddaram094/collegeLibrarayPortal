package com.college.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.college.library.domain.BookIssue;

@Repository
public interface BookIssueRepository extends JpaRepository<BookIssue, Long> {

	@Query(value="SELECT count(*) as bookCount FROM collegelibraryportal.book_issue where studentusn=?1",nativeQuery = true)
	int getAllocatedBooksForStudent(String usn);
	
	List<BookIssue> findByStudentUSN(String usn);
}
