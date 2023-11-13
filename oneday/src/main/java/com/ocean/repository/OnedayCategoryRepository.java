package com.ocean.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ocean.model.entity.OnedayCategory;

public interface OnedayCategoryRepository extends JpaRepository<OnedayCategory, Integer> {
	
}
