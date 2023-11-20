package com.ocean.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ocean.model.entity.Oneday;
import com.ocean.model.entity.OnedayCategory;
import com.ocean.repository.OnedayCategoryRepository;
import com.ocean.repository.OnedayRepository;

@Service
public class OnedayService {
	@Autowired
	private OnedayRepository onedayRepository;
	
	@Autowired
	private OnedayCategoryRepository onedayCategoryRepository;
	
	public Oneday getOneday(int id) throws DataAccessException {
		Optional<Oneday> optionalOneday = onedayRepository.findById(id);
		Oneday oneday;
		if (optionalOneday.isPresent()) {
			oneday = optionalOneday.get();
		} else {
			oneday = null;
		}
		return oneday;
	}
	
	public Oneday getOneday(String name) throws DataAccessException {
		Optional<Oneday> optionalOneday = onedayRepository.findByName(name);
		Oneday oneday;
		if (optionalOneday.isPresent()) {
			oneday = optionalOneday.get();
		} else {
			oneday = null;
		}
		return oneday;
	}
	
	public List<Oneday> getAllOnedayList() throws DataAccessException {
		List<Oneday> allOnedayList = onedayRepository.findAll();
		return allOnedayList;
	}
	
	public List<Oneday> getOnedayList(int categoryCode) throws DataAccessException {
		OnedayCategory category = getCategory(categoryCode);
		List<Oneday> onedayList = onedayRepository.findByCategory(category);
		return onedayList;
	}
	
	public OnedayCategory getCategory(int categoryCode) throws DataAccessException {
		Optional<OnedayCategory> optionalCategory = onedayCategoryRepository.findById(categoryCode);
		OnedayCategory category = null;
		if (optionalCategory.isPresent()) {
			category = optionalCategory.get();
		} 
		return category;
	}
	
}
