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

}
