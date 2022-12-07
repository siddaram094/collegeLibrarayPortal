package com.college.library.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.library.domain.Book;
import com.college.library.domain.BookIssue;

@RestController
public interface BookIssueResource {
 
	@PostMapping("/issueBook")
	ResponseEntity<Object> issueBook(@RequestBody BookIssue bookIssue );
	
	@GetMapping("/getBookIssued/{studentUSN}")
	ResponseEntity<List<Book>> getBookIssueForStudent(@PathVariable("studentUSN") String usn);
}
