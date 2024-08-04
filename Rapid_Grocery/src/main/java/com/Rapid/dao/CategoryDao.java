package com.Rapid.dao;

import java.util.List;

import com.Rapid.bean.CategoryBean;
import com.Rapid.model.Category;

public interface CategoryDao {
	
	public void addCategory(CategoryBean category);
	
	public List<Category> listCategory();
	
	public void deleteCategory(Integer categoryId);

	public Category getCategory(Integer categoryId);
}
