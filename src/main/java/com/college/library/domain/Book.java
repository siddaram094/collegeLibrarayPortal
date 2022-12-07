package com.college.library.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String bookTitle;
	private String authors;
	private String publisher;
	private String isbn;
	private String tag;
	private int quantity;
	
	
	
}
