package com.college.library.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.library.domain.Book;

@RestController
public interface BookResource {

	@PostMapping("/saveBook")
	ResponseEntity<Object> persistBook(@RequestBody Book book);
	@PutMapping("/updateBook")
	ResponseEntity<Object> updateBook(@RequestParam("bookTitle")String bootTitle,@RequestParam("quantity") int quantity,@RequestParam("author") String author);
	@GetMapping("/getByTag")
	ResponseEntity<Object> getBookByTag(@RequestParam("tag") String tag); 
	@GetMapping("/getBooksByAuthor")
	ResponseEntity<Object> getBooksByAuthor(@RequestParam("author") String author);
	@GetMapping("/getBookByIds")
	ResponseEntity<Object> getBooksByIds(@RequestParam("bookIds") List<Long> bookIds);
}
