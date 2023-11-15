package com.ocean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ocean.model.entity.Oneday;
import com.ocean.model.entity.Question;
import com.ocean.model.entity.User;
import com.ocean.repository.OnedayRepository;
import com.ocean.repository.QuestionRepository;
import com.ocean.repository.UserRepository;

@SpringBootApplication
public class OnedayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnedayApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner runner(UserRepository userRepository,OnedayRepository onedayRepository, QuestionRepository questionRepository) throws Exception{
		return (args) ->{
			User user = userRepository.save(User.addUser("havi", "havi", "test", "여자", "2000", "123-123", "123@1234", "admin"));
					
			
			Oneday oneday = onedayRepository.save(Oneday.builder()
				.oneday_name("댄스")
				.oneday_content("내용")
				.oneday_curri("1234")
				.oneday_location("광진구")
				.oneday_date(LocalDateTime.now())
				.build());
			
			IntStream.range(1, 200).forEach(index ->
				questionRepository.save(Question.builder()
						.question_title("게시글"+index)
						.question_content("콘텐츠")
						.question_date(LocalDateTime.now())
						.question_mdate(LocalDateTime.now())
						.user(user).build()
						.oneday(oneday).build())
								);
		};
	}*/

}
