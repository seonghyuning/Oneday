package com.ocean.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class Oneday {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	
	@ManyToOne
	private OnedayCategory category;
	
	@ManyToOne
	private User user;
	
	@Column(length=100, name="oneday_name", nullable = false)
	private String name;
	
	@Column(length=2000, name="oneday_content", nullable = false)
	private String content;
	
	@Column(length=2000, name="oneday_curri", nullable = false)
	private String curri;
	
	@Column(length=100, name="oneday_location", nullable=false)
	private String location;
	
	@Column(name="oneday_view", nullable = false)
	private int view = 0;
	
	@CreationTimestamp
	@Column(name="oneday_date", nullable = false)
	private LocalDateTime date;
	
	@CreationTimestamp
	@Column(name="oneday_mdate")
	private LocalDateTime mdate;

}
