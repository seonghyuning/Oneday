package com.ocean.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ocean.model.entity.Question;
import com.ocean.repository.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	
	public Page<Question> findQuestionList(Pageable pageable){
		pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1, pageable.getPageSize());
		return questionRepository.findAll(pageable);
	}
	public Question findQuestionById(int id) {
		return questionRepository.findById(id).orElse(new Question());
	}

}
