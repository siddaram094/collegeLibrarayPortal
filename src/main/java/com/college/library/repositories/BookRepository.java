package com.college.library.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.college.library.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(value="SELECT * from Book where book_Title=?1 and authors=?2",nativeQuery = true)
	Book findBookByTitleAndAuthor(String bookTitle,String authors);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE Book SET quantity= ?1 where book_Title=?2 and authors=?3",nativeQuery = true)
	void updateBook(int quantity,String bookTitle,String authors);
	
	List<Book> findByTag(String tag);
	
	List<Book> findByAuthors(String author);
}
