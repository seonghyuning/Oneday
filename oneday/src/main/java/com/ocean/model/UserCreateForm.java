package com.ocean.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
	@NotEmpty(message="이름을 입력해주세요.")	// 비어있으면 이 메시지 띄워줌
	private String nickname;
	
	@Size(min=5, max=20, message="사용자 아이디를 5 ~ 20자 사이로 입력해주세요.")
	@NotEmpty(message="사용자 아이디를 입력해주세요.")
	private String username;	// 중복체크
	
	@NotEmpty(message="비밀번호를 입력해주세요.")
	private String password1;
	
	@NotEmpty(message="비밀번호 확인을 입력해주세요.")
	private String password2;
	
	@NotEmpty(message="성별을 선택해주세요.")
	private String gender;
	
	@NotEmpty(message="생년을 입력해주세요.")
	private String year;
	
	@NotEmpty(message="핸드폰 번호를 입력해주세요.")
	private String phoneNm;		// 본인인증
	
	@NotEmpty(message="이메일을 입력해주세요.")
	private String email;
	
	@NotEmpty(message="권한을 선택해주세요.")
	private String role;
}
