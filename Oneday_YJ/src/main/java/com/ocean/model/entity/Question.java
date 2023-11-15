package com.ocean.model.entity;
  
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
  
@Getter 
@NoArgsConstructor
@Entity
@Table 
public class Question {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
  
	@Column
	private String question_title;
  
	@Column 
	private String question_content;
  
	@Column 
	private LocalDateTime question_date;
  
	@Column 
	private LocalDateTime question_mdate;
  
	@ManyToOne(fetch = FetchType.LAZY) 
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	private Oneday oneday;
	
	@Builder
	public Question(String question_title, String question_content, LocalDateTime question_date, LocalDateTime question_mdate, User user, Oneday oneday) {
		this.question_title = question_title;
		this.question_content = question_content;
		this.question_date = question_date;
		this.question_mdate = question_mdate;
		this.user = user;
		this.oneday = oneday;
	}
}
 