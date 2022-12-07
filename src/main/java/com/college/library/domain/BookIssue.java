package com.college.library.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "BOOK_ISSUE")
public class BookIssue {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long Id;
	private String studentUSN;
	
	private Long bookId;  
	
	private Date issueDate;
	
	private Date returnDate;
	
}
