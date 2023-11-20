package com.ocean.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ocean.model.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
	User findById(int userId);
}
