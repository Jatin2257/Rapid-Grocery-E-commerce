package com.rapid.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rapid.bean.CategoryBean;
import com.rapid.dao.CategoryDao;
import com.rapid.dao.CategoryDaoImpl;
import com.rapid.model.Category;

@Service("categoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> listCategory() {
		return categoryDao.listCategory();
	}

}


