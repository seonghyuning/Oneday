package com.ocean.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class User {
	@Id
	// @GeneratedValue, @Column은 세트
	@GeneratedValue(strategy=GenerationType.IDENTITY)	// auto_increment
	@Column(nullable = false)	 // DB에 컬럼명을 이것으로 만들어 줌. 디폴트값: 필드명=컬럼명
	private int id;
	
	@Column(unique=true, length=50, nullable = false)	 // column을 unique 키로 설정
	private String username;
	
	@Column(length=50, nullable = false)
	private String nickname;
	
	@Column(nullable = false)
	private String password;	// 암호화된 password가 들어가므로 길이 짧게 지정 X
	
	@Column(length=50, nullable = false)
	private String phoneNm;
	
	@Column(length=50, nullable = false)
	private String email;
	
	@Column(length=10, name="user_role", nullable = false)
	private String role;
	
	// 프로필이미지 칼럼 나중에 추가
	
	@Column(length=5, nullable = false)
	private String gender;
	
	@Column(length=5, nullable = false)
	private String year;
	
	@CreationTimestamp	// default값: 현재 시간
	@Column(nullable = false)
	private LocalDateTime createDate;
}
