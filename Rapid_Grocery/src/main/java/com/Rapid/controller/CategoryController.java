package com.Rapid.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.LoggerInfo;

import com.Rapid.model.Category;

import com.Rapid.service.CategoryService;

@Controller
public class CategoryController {

	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	public ModelAndView insertCategory(@ModelAttribute("Category") CategoryBean category, BindingResult result) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		
		categoryService.addCategory(category);
		Map<String, Object> model = new HashMap<String, Object>();
		List<Category> list = categoryService.listCategory();
		model.put("categorys", prepareListofBean(list));
		return new ModelAndView("category_list", model);}
		return new ModelAndView("redirect:/signin");
	}
	
	
	@RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@ModelAttribute("Category") CategoryBean category, BindingResult result) {
		
		
		categoryService.deleteCategory(category.getCategoryId());
		Map<String, Object> model = new HashMap<String, Object>();
		List<Category> list = categoryService.listCategory();
		model.put("category", null);
		model.put("categorys", prepareListofBean(list));
		return new ModelAndView("redirect:/category_list");

	}
	
	//for edit
	@RequestMapping(value = "/editCategory", method = RequestMethod.GET)
	public ModelAndView editCategory(@ModelAttribute("Category") CategoryBean category1, BindingResult result) {
	
		
		Category category = categoryService.getCategory(category1.getCategoryId());
		category1.setCategoryId(category.getCategoryId());
		category1.setCategoryName(category.getCategoryName());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("category", category1);
		return new ModelAndView("category", model);
	}
		
	
	
	
	@RequestMapping(value="/category_list", method = RequestMethod.GET)
	public ModelAndView viewAllCategory() {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Category> list = categoryService.listCategory();
		model.put("categorys", prepareListofBean(list));
		return new ModelAndView("category_list", model);}
		return new ModelAndView("redirect:/signin");
	}
	
	private List<CategoryBean> prepareListofBean(List<Category> cat){
		List<CategoryBean> beans = null;
		if(cat != null && !cat.isEmpty()){
			beans = new ArrayList<CategoryBean>();
			CategoryBean bean = null;
			for(Category category : cat){
				bean = new CategoryBean();
				bean.setCategoryId(category.getCategoryId());
				bean.setCategoryName(category.getCategoryName());
				beans.add(bean);
			}
		}
		return beans;
	}
}



