package com.ocean.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ocean.model.entity.Question;
import com.ocean.model.entity.User;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	Question findByUser(User user);
	List<Question> findByUserId(int id);
}
