package com.college.library.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.library.domain.Book;
import com.college.library.domain.BookIssue;
import com.college.library.service.BookIssueService;

@RestController
@RequestMapping("/bookIssue")
public class BookIssueResourceImpl implements BookIssueResource {

	@Autowired
	BookIssueService bookIssueService;
	@Override
	public ResponseEntity<Object> issueBook(BookIssue bookIssue) {
		return new ResponseEntity<Object>(bookIssueService.issueBook(bookIssue), HttpStatus.OK);
	}
	@Override
	public ResponseEntity<List<Book>> getBookIssueForStudent(String usn) {
		return new ResponseEntity<List<Book>>(bookIssueService.getIssuedBookForStudent(usn), HttpStatus.OK); 
	}

}
