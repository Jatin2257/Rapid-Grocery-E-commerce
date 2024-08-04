package com.Rapid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Rapid.bean.CategoryBean;
import com.Rapid.model.Category;

@Service
public interface CategoryService {

	public void addCategory(CategoryBean category);
	
	public List<Category> listCategory();
	
	public void deleteCategory(Integer categoryId);

	public Category getCategory(Integer categoryId);

}
