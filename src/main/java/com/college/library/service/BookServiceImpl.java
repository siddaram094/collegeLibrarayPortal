package com.college.library.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.library.domain.Book;
import com.college.library.error.BookException;
import com.college.library.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;
	@Override
	public String persistBook(Book book) {
		Book bookData=bookRepository.findBookByTitleAndAuthor(book.getBookTitle(), book.getAuthors()); 
		if(bookData!=null) { 
			throw new BookException("Book "+book.getBookTitle() +" with author "+book.getAuthors()+" already exists");
		}else {
			bookRepository.save(book);
		}
		return "Book "+book.getBookTitle() +" saved successfully";
	}
	
	@Transactional
	@Override
	public String updateBook(String bookTitle, int quantity, String author) {
		Book bookData=bookRepository.findBookByTitleAndAuthor(bookTitle, author); 
		if(bookData!=null) { 
			quantity=bookData.getQuantity()+quantity;
			bookRepository.updateBook(quantity, bookTitle, author);
		}else {
			throw new BookException("Book "+bookTitle +" with author "+author+" not exists");
			
		}
		return "Book "+bookTitle +" updated successfully";
	}

	@Override
	public List<Book> getBooksByTag(String tag) {
		List<Book> books=bookRepository.findByTag(tag);
		if(books.isEmpty()) {
			 throw new BookException("No Books with tag "+tag);
		}
		return books;
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		List<Book> books=bookRepository.findByTag(author);
		if(books.isEmpty()) {
			 throw new BookException("No Books with author "+author);
		}
		return books;
	}

	@Override
	public List<Book> getBooksForIds(List<Long> bookIds) {
		List<Book> books = bookRepository.findAllById(bookIds);
		if(books.isEmpty()) {
				throw new BookException("No Books Present");
		}else {
			return books;
		}
	}

}
