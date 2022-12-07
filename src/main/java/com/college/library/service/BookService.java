package com.college.library.service;


import java.util.List;
import com.college.library.domain.Book;

public interface BookService {

	String persistBook(Book book);

	String updateBook(String bootTitle, int quantity, String author);

	List<Book> getBooksByTag(String tag);

	List<Book> getBooksByAuthor(String author);  
	
	List<Book> getBooksForIds(List<Long> bookIds);
}
