package com.ocean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ocean.service.OnedayService;
import com.ocean.model.entity.Oneday;
import com.ocean.model.entity.Question;
import com.ocean.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
    private QuestionService questionService;

	@Autowired
	private OnedayService onedayService;

	@GetMapping("/form")
    public String showQuestionForm(Model model) {
        List<Oneday> onedayList = onedayService.getAllOnedayList();
        model.addAttribute("question", new Question());
        model.addAttribute("onedayList", onedayList);
        return "/question/form";
    }

    @PostMapping("/add")
    public String addQuestion(@ModelAttribute Question question) {
        questionService.addQuestion(question);
        return "redirect:/question/list";
    }
    

    @GetMapping("/list")
    public String showQuestionList(Model model) {
        List<Question> questions = questionService.getQuestionsByCurrentUser();
        model.addAttribute("questions", questions);
        return "question/list";
    }
    
}
