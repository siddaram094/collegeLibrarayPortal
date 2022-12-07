package com.college.library.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.college.library.domain.Book;
import com.college.library.domain.BookIssue;

@Service
public interface BookIssueService {

	String issueBook(BookIssue bookIssue);

	List<Book> getIssuedBookForStudent(String usn); 
}
