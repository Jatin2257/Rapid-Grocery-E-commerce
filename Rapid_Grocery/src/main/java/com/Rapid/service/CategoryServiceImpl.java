package com.Rapid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Rapid.bean.CategoryBean;
import com.Rapid.dao.CategoryDao;
import com.Rapid.dao.CategoryDaoImpl;
import com.Rapid.model.Category;

@Service("categoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	//add Category
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCategory(CategoryBean category) {
		categoryDao.addCategory(category);
	}
	

	@Override
	public List<Category> listCategory() {
		return categoryDao.listCategory();
	}

	@Override
	@Transactional
	public void deleteCategory(Integer categoryId) {
		categoryDao.deleteCategory(categoryId);
	}

	@Override
	public Category getCategory(Integer categoryId) {
		return categoryDao.getCategory(categoryId);
	}	
}
