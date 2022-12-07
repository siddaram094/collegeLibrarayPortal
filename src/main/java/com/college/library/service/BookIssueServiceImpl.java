package com.college.library.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.library.domain.Book;
import com.college.library.domain.BookIssue;
import com.college.library.error.BookIssueException;
import com.college.library.repositories.BookIssueRepository;
import com.college.library.repositories.BookRepository;

@Service
public class BookIssueServiceImpl implements BookIssueService {

	@Autowired
	BookIssueRepository bookIssueRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookService bookService;
	
	@Override
	public String issueBook(BookIssue bookIssue) {
		int count = bookIssueRepository.getAllocatedBooksForStudent(bookIssue.getStudentUSN());
		if(count<5) {
		bookIssueRepository.save(bookIssue);
	}else 
	{
		throw new BookIssueException("Student had already issued max books");
	}
		return "book Issued Succesfully";
	}

	@Override
	public List<Book> getIssuedBookForStudent(String usn) {
		int count = bookIssueRepository.getAllocatedBooksForStudent(usn);
		if(count==0) {
			throw new BookIssueException("Student has not allocated any Books");
		}else {
		List<BookIssue> issue= bookIssueRepository.findByStudentUSN(usn); 
		List<Long> bookIds=issue.stream().map(book->book.getBookId()).collect(Collectors.toList());
		List<Book> issuedBooks =bookService.getBooksForIds(bookIds) ;
		
		return issuedBooks;
		}
	}
}
