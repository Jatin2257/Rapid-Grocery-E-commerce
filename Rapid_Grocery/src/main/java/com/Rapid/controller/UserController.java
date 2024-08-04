package com.Rapid.controller;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Rapid.bean.LoggerInfo;
import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.bean.UserMasterBean;
import com.Rapid.model.SubproductMaster;
import com.Rapid.model.UserMaster;

import com.Rapid.service.UserService;

@Controller
public class UserController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;
	


	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ModelAndView insertCategory(@ModelAttribute("User") UserMasterBean userMaster,
			BindingResult bindingResult) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		userService.addUser(userMaster);

		System.out.println("............................");
		Map<String, Object> model = new HashMap<String, Object>();

		List<UserMaster> list = userService.listUser();

		model.put("users", prepareListofBean(list));
		return new ModelAndView("redirect:/user_list", model);
	}
	return new ModelAndView("redirect:/signin");
	}

//	
	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public ModelAndView viewAllUser() {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<UserMaster> list = userService.listUser();
		model.put("users", prepareListofBean2(list));
		return new ModelAndView("user_list", model);}
		return new ModelAndView("redirect:/signin");
	}

//	//for delete
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(@ModelAttribute("User") UserMasterBean userMaster, BindingResult result) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		
		userService.deleteUser(userMaster.getUserMasterId());
		Map<String, Object> model = new HashMap<String, Object>();
		List<UserMaster> list = userService.listUser();
		
		model.put("user", null);
		model.put("users", prepareListofBean(list));
		return new ModelAndView("redirect:/user_list");}
		return new ModelAndView("redirect:/signin");

	}
	
	@RequestMapping(value = "/updateActiveUser", method = RequestMethod.GET)
	public ModelAndView updateActiveUser(@ModelAttribute("User") UserMasterBean user, BindingResult result) {
		userService.updateActiveUser(user.getUserMasterId());
		/*user.setUserMasterId(userMaster.getUserMasterId());
		if(userMaster.getIsActive()== "0") {
		user.setIsActive("1");
		}else {
			user.setIsActive("0");
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", userMaster);*/
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		return new ModelAndView("redirect:/user_list");}
		return new ModelAndView("redirect:/signin");

	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("LoggerInfo");
		session.invalidate();
		return "redirect:/signin";
	}
	
	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public ModelAndView checklogin(Model model, @ModelAttribute("User") UserMasterBean userMaster,
			BindingResult bindingResult, HttpSession session) {
	if ((userMaster.getUserEmailId() != null) && (userMaster.getUserPassword() != null)) {
		if(userService.checkLogin(userMaster, session) == true) {	
			
			return new ModelAndView("redirect:/");
		}else {
			
			return new ModelAndView("redirect:/signin");
		}
	}
	else{
		model.addAttribute("error", "Please enter Details");
		return new ModelAndView("redirect:/signin");
    }
}
	
	
	
	
//	
//	//for edit
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editCategory(@ModelAttribute("User") UserMasterBean user , BindingResult result) {
		UserMaster userMaster = userService.getUser(user.getUserMasterId());
		
		user.setUserMasterId(userMaster.getUserMasterId());
		user.setUserMasterFirstName(userMaster.getUserMasterFirstName());
		user.setUserMasterLastName(userMaster.getUserMasterLastName());
		user.setUserEmailId(userMaster.getUserEmailId());
		user.setUserAddress(userMaster.getUserAddress());
		user.setUserContact(userMaster.getUserContact());
		user.setUserDOB(userMaster.getUserDOB());
		user.setUserPassword(userMaster.getUserPassword());
		user.setUserTId(userMaster.getUserTId());
		user.setUserSalary(userMaster.getUserSalary());
		user.setIsActive(userMaster.getIsActive());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", user);
		return new ModelAndView("userinsert", model);
	}

	private List<UserMasterBean> prepareListofBean(List<UserMaster> cat) {
		List<UserMasterBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<UserMasterBean>();
			UserMasterBean bean = null;
			for (UserMaster subProduct : cat) {
				
				bean = new UserMasterBean();
				bean.setUserMasterId(subProduct.getUserMasterId());
				bean.setUserMasterFirstName(subProduct.getUserMasterFirstName());
				bean.setUserMasterLastName(subProduct.getUserMasterLastName());
				bean.setUserEmailId(subProduct.getUserEmailId());
				bean.setUserAddress(subProduct.getUserAddress());
				bean.setUserContact(subProduct.getUserContact());
				bean.setUserDOB(subProduct.getUserDOB());
				bean.setUserPassword(subProduct.getUserPassword());
				bean.setUserTId(subProduct.getUserTId());
				bean.setUserSalary(subProduct.getUserSalary());
				bean.setIsActive(subProduct.getIsActive());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	
	private List<UserMasterBean> prepareListofBean2(List<UserMaster> cat) {
		List<UserMasterBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<UserMasterBean>();
			UserMasterBean bean = null;
			Iterator itr = cat.iterator();
			while (itr.hasNext()) {
				bean = new UserMasterBean();
				Object[] obj = (Object[]) itr.next();
				int i = 0;

				bean.setUserMasterId(Integer.parseInt(String.valueOf(obj[0])));
				bean.setUserMasterFirstName(String.valueOf(obj[1]));
				bean.setUserMasterLastName(String.valueOf(obj[2]));
				bean.setUserEmailId(String.valueOf(obj[3]));
				bean.setUserAddress(String.valueOf(obj[5]));
				bean.setUserContact(Long.parseLong(String.valueOf(obj[4])));
				bean.setUserPassword(String.valueOf(obj[6]));
				bean.setUserTId(Integer.parseInt(String.valueOf(obj[10])));
				bean.setIsActive(String.valueOf(obj[9]));
				bean.setUserTypeName(String.valueOf(obj[11]));
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			     
			    Date date=null;
				try {
					date = formatter.parse(String.valueOf(obj[7]));
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			      
				bean.setUserDOB(date);
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
