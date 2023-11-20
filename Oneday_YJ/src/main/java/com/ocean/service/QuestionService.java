package com.ocean.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocean.model.entity.Question;
import com.ocean.repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
    private QuestionRepository questionRepository;
	@Autowired
	private UserService userService;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question addQuestion(Question question) {
        // 필요한 비즈니스 로직 또는 유효성 검사를 수행합니다.
        question.setQuestion_date(LocalDateTime.now());
        // 데이터베이스에 질문을 저장합니다.
        return questionRepository.save(question);
    }

	
	public List<Question> listQuestions() throws DataAccessException {
		List<Question> questionList = questionRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		return questionList;
	}
	
	@Transactional(readOnly = true)
    public List<Question> getQuestionsByCurrentUser() {
        Integer userId = userService.getUserId();
        return questionRepository.findByUserId(userId);
    }
    
}
