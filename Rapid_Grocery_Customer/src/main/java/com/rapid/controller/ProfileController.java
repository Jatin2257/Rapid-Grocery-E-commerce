package com.rapid.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rapid.bean.UserMasterBean;

import com.rapid.model.UserMaster;
import com.rapid.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/adduser1", method = RequestMethod.POST)
	public ModelAndView adduser1(@ModelAttribute("User") UserMasterBean userMaster, BindingResult bindingResult) {
		profileService.addUser(userMaster);
		return new ModelAndView("redirect:/profile");
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView viewAllUser(HttpSession session) {
		Map<String, Object> model = new HashMap<String, Object>();
		int id = (int) session.getAttribute("Id");
		UserMaster userMaster = profileService.listUser(id);
		model.put("User", userMaster);
		return new ModelAndView("profile", model);
	}

//	private List<UserMasterBean> prepareListofBean(List<UserMaster> cat) {
//		List<UserMasterBean> beans = null;
//		if (cat != null && !cat.isEmpty()) {
//			beans = new ArrayList<UserMasterBean>();
//			UserMasterBean bean = null;
//			for (UserMaster subProduct : cat) {
//
//				bean = new UserMasterBean();
//				bean.setUserMasterId(subProduct.getUserMasterId());
//				bean.setUserMasterFirstName(subProduct.getUserMasterFirstName());
//				bean.setUserMasterLastName(subProduct.getUserMasterLastName());
//				bean.setUserEmailId(subProduct.getUserEmailId());
//				bean.setUserAddress(subProduct.getUserAddress());
//				bean.setUserContact(subProduct.getUserContact());
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}
//
//	private List<UserMasterBean> prepareListofBean2(List<UserMaster> cat) {
//		List<UserMasterBean> beans = null;
//		if (cat != null && !cat.isEmpty()) {
//			beans = new ArrayList<UserMasterBean>();
//			UserMasterBean bean = null;
//			Iterator itr = cat.iterator();
//			while (itr.hasNext()) {
//				bean = new UserMasterBean();
//				Object[] obj = (Object[]) itr.next();
//				int i = 0;
//
//				bean.setUserMasterId(Integer.parseInt(String.valueOf(obj[0])));
//				bean.setUserMasterFirstName(String.valueOf(obj[1]));
//				bean.setUserMasterLastName(String.valueOf(obj[2]));
//				bean.setUserEmailId(String.valueOf(obj[3]));
//				bean.setUserAddress(String.valueOf(obj[5]));
//				bean.setUserContact(Long.parseLong(String.valueOf(obj[4])));
//				bean.setUserPassword(String.valueOf(obj[6]));
//				beans.add(bean);
//			}
//
//		}
//		return beans;
//	}

}
