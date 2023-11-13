package com.ocean.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ocean.model.entity.User;
import com.ocean.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User addUser(String nickname, String username, String password,
						String gender, String year, String phoneNm,
						String email, String role) {
		User user = new User();
		user.setNickname(nickname);
		user.setUsername(username);
		user.setGender(gender);
		user.setYear(year);
		user.setPhoneNm(phoneNm);
		user.setEmail(email);
		user.setRole(role);
		// password를 그냥 넣지 말고 암호화 시켜서 넣어줘야 함
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		return user;
	}
	
	public List<User> listUsers() throws DataAccessException {
		List<User> userList = userRepository.findAll(Sort.by(Sort.Direction.ASC, "nickname"));
		return userList;
	}
	
	public User getUser(String username) throws DataAccessException {
		Optional<User> optionalUser = userRepository.findByUsername(username);
		User user = null;
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
		} else {
			user = null;
		}
		return user;
	}
	
	public void deleteUser(String username) throws DataAccessException {
		Optional<User> optionalUser = userRepository.findByUsername(username);
		User user = null;
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
			userRepository.delete(user);
		} else {
			throw new DataNotFoundException("user not found");
		}
	}
}
