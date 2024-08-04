package com.Rapid.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Rapid.bean.CategoryBean;
import com.Rapid.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	GeneralImp generalImp;
	
	public void addCategory(CategoryBean categoryBean) {
		Category category = covertFomBeanToModel(categoryBean); 
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}
	
	private Category covertFomBeanToModel(CategoryBean categoryBean) {
		Category category = new Category();
		category.setCategoryId(categoryBean.getCategoryId());
		category.setCategoryName(categoryBean.getCategoryName());
		return category;
	}

	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Category> listCategory() {
		return (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).list();
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		String hqlQueryString = "DELETE FROM Category WHERE categoryId = "+categoryId;
		generalImp.deleteByHQL(hqlQueryString, sessionFactory);
	}

	@Override
	public Category getCategory(Integer categoryId) {
		return (Category) generalImp.getById(Category.class, categoryId, sessionFactory);
	}
	
	
}
