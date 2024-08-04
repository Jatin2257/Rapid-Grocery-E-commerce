package com.Rapid.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Rapid.bean.LoggerInfo;
import com.Rapid.bean.UserMasterBean;
import com.Rapid.bean.UserSalaryBean;


import com.Rapid.model.UserSalary;
import com.Rapid.service.SalaryService;


@Controller
public class UserSalaryController {

	@Autowired
	private SalaryService salaryService;

	
	@Autowired
	private HttpSession session;
	
	@Transactional
	@RequestMapping(value = "/addSalaryUser", method = RequestMethod.GET)
	public ModelAndView addSalaryUser(UserSalaryBean userSalary,
			BindingResult bindingResult) {
		
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		salaryService.addSalary(userSalary);

		
		Map<String, Object> model = new HashMap<String, Object>();

		List<UserSalary> list = salaryService.listUserSalary();
		
		model.put("salarys", prepareListofBean(list));
		return new ModelAndView("redirect:/salary_list", model);}
		return new ModelAndView("redirect:/signin");
	}


	
	
//	
	@RequestMapping(value = "/salary_list", method = RequestMethod.GET)
	public ModelAndView viewAllUser() {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		List<UserSalary> list = salaryService.listUserSalary();
		model.put("salarys", prepareListofBean(list));
		return new ModelAndView("salary_list", model);}
		return new ModelAndView("redirect:/signin");
	}

////	//for delete
//	@RequestMapping(value = "/deleteSalary", method = RequestMethod.GET)
//	public ModelAndView deleteUser(UserSalaryBean userSalary, BindingResult result) {
//		salaryService.deleteSalary(userSalary.getUserMasterId());
//		Map<String, Object> model = new HashMap<String, Object>();
//		List<UserSalary> list = salaryService.listUser();
//		model.put("user", null);
//		model.put("users", prepareListofBean(list));
//		return new ModelAndView("redirect:/user_list");
//
//	}
	
	@RequestMapping(value = "/updatePaidSalary", method = RequestMethod.GET)
	public ModelAndView updatePaidUser(UserSalaryBean user, BindingResult result) {
		salaryService.updatePaidSalary(user.getUserSalaryId());
		/*user.setUserMasterId(userMaster.getUserMasterId());
		if(userMaster.getIsActive()== "0") {
		user.setIsActive("1");
		}else {
			user.setIsActive("0");
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", userMaster);*/
	
		return new ModelAndView("redirect:/user_list");

	}
	
	
	
	
//	
//	//for edit
//	@RequestMapping(value = "/editSalary", method = RequestMethod.GET)
//	public ModelAndView editCategory( UserSalaryBean userSalary , BindingResult result) {
//		UserSalary UserSalary = salaryService.getSalary(userSalary.getUserMasterId(),userSalary.getUserSalary());
//		
//	
//		return new ModelAndView("redirect:/salary_list");
//	}

	private List<UserSalaryBean> prepareListofBean(List<UserSalary> cat) {
		List<UserSalaryBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<UserSalaryBean>();
			UserSalaryBean bean = null;
			for (UserSalary userSalary : cat) {
				
				bean = new UserSalaryBean();
				
				bean.setUserMasterId(userSalary.getUserMasterId());
				bean.setUserSalaryId(userSalary.getUserSalaryId());
				System.out.println(userSalary.getUserSalary());
				bean.setUserSalary(userSalary.getUserSalary());
				bean.setUserSalaryDate(userSalary.getUserSalaryDate());
				bean.setIsPaid(userSalary.getIsPaid());
				
				
				beans.add(bean);
			}
		}
		return beans;
	}

//	private Date changedate(Date userDOB) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
//
//		String datesString = "";
//		datesString = dateFormat.format(userDOB);
//		try {
//			userDOB = (Date) dateFormat.parse(datesString);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return userDOB;
//
//	}

	
	
	
//	private Category prepareModel(CategoryBean categoryBean) {
//		Category category = new Category();
//		category.setCategoryId(categoryBean.getCategoryId());
//		category.setCategoryName(categoryBean.getCategoryName());
//		categoryBean.setCategoryId(null);
//		return category;
//	}

//	private CategoryBean prepareCategoryBean(Category category){
//		CategoryBean bean = new CategoryBean();
//		bean.setCategoryId(category.getCategoryId());
//		bean.setCategoryName(category.getCategoryName());
//		return bean;
//	}

}
