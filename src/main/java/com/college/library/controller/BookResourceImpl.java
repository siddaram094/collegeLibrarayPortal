package com.college.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.library.domain.Book;
import com.college.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookResourceImpl implements BookResource {

	@Autowired
	BookService bookService;
	@Override
	public ResponseEntity<Object> persistBook(Book book) {
		return new ResponseEntity<Object>(bookService.persistBook(book), HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Object> updateBook(String bootTitle, int quantity, String author) {
		return new ResponseEntity<Object>(bookService.updateBook(bootTitle,quantity,author), HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Object> getBookByTag(String tag) {
		return new ResponseEntity<Object>(bookService.getBooksByTag(tag), HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Object> getBooksByAuthor(String author) {
		return  new ResponseEntity<Object>(bookService.getBooksByAuthor(author), HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Object> getBooksByIds(List<Long> bookIds) {
		return new ResponseEntity<Object>(bookService.getBooksForIds(bookIds), HttpStatus.OK); 
	}
	
	

	

}
