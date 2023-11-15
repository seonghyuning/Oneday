package com.ocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ocean.service.QuestionService;

@Controller
@RequestMapping("/qusetion")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping({"","/"})
	public String question(@RequestParam(value = "id", defaultValue ="0") int id, Model model) {
		model.addAttribute("question", questionService.findQuestionById(id));
		return "/question/form";
	}
	
	@GetMapping("/list")
	public String list(@PageableDefault Pageable pageable, Model model) {
		model.addAttribute("questionList", questionService.findQuestionList(pageable));
		return "question/list";
				
	}
	
}
