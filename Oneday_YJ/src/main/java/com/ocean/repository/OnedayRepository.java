package com.ocean.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ocean.model.entity.Oneday;
import com.ocean.model.entity.OnedayCategory;

public interface OnedayRepository extends JpaRepository<Oneday, Integer> {
	//@Query("SELECT o FROM Oneday o WHERE o.category.code = :categoryCode")
	List<Oneday> findByCategory(OnedayCategory category);
	Optional<Oneday> findByName(String name);
}

