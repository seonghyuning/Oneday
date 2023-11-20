package com.ocean.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ocean.model.entity.Oneday;
import com.ocean.service.OnedayService;

@Controller
public class OnedayController {
	@Autowired
	private OnedayService onedayService;
	
	@GetMapping({"/main", "/"})
	public String getMainPage(Model model) {
		List<Oneday> allOnedayList = onedayService.getAllOnedayList();
		model.addAttribute("onedayList", allOnedayList);
		return "main";
	}
	
	@GetMapping("/category")
	public String category(@RequestParam(value="page") String categoryCode, Model model) {
		List<Oneday> onedayList = onedayService.getOnedayList(Integer.parseInt(categoryCode));
		//OnedayCategory category = onedayService.getCategory(Integer.parseInt(categoryCode));
		model.addAttribute("onedayList", onedayList);
		//model.addAttribute("category", category.getName());
		//attr.addAttribute("page", categoryCode);
		return "category";
	}
	
	@RequestMapping("/board/search")
	public String search(Model model, @RequestParam(value="onedayName") String onedayName) {
		List<Oneday> onedayList = new ArrayList<>();
		Oneday oneday = new Oneday();
		oneday = onedayService.getOneday(onedayName);
		if (oneday == null) {
			return "board/search";
		}
		onedayList.add(oneday);
		model.addAttribute("onedayList", onedayList);
		return "board/search";
	}
}
