package com.ocean.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ocean.model.UserRole;
import com.ocean.model.entity.User;
import com.ocean.repository.UserRepository;

@Service
// UserDetailsService: DB에서 인증정보 획득
public class UserSecurityService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	// UserDetails: DB에 인증정보 전달
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalUser = userRepository.findByUsername(username);
		if (optionalUser.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}
		User user = optionalUser.get();
		
		// 자바 내장 클래스 GrantedAuthority 자료형으로 리스트를 만듦
		// UserRole에서 권한(ADMIN or USER)를 얻어와서 넣기 위한 용도
		List<GrantedAuthority> authorities = new ArrayList<>();
		if ("관리자".equals(user.getRole())) {
			// role이 관리자이면 관리자(ADMIN) 권한을 얻어서 내장 권한 클래스 리스트에 넣음
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
		} else {
			// 아니면 일반 사용자 권한(USER)을 얻어서 내장 권한 클래스 리스트에 넣음
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}
		
		// 자바 내장 클래스 USER
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
}
