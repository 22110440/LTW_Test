package com.ltw.test.dao;

import com.ltw.test.model.Category;
import java.util.List;

public interface CategoryDao {
	Category findById(Long id);
	Category findByCode(String code);
	List<Category> findAll();
	void save(Category c);
	void update(Category c);
	void delete(Long id);
	List<Category> findPage(int pageIndex, int pageSize);
	long countAll();
	long countVideosByCategory(Long categoryId);


}


