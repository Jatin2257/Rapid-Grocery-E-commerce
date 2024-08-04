package com.Rapid.controller;

import java.util.HashMap;
import java.util.Map;

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
import com.Rapid.bean.UserMasterBean;

import com.Rapid.model.UserMaster;
import com.Rapid.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public ModelAndView adduser1(@ModelAttribute("MyProfile") UserMasterBean userMaster, BindingResult bindingResult) {
		profileService.addUser(userMaster);
		return new ModelAndView("redirect:/profile");
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView viewProfile(HttpSession session, Model model) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {			
			Map<String, Object> model1 = new HashMap<String, Object>();
			UserMaster userMaster = profileService.listUser(loggerInfo.getUserMasterId());
			model1.put("User", userMaster);
			return new ModelAndView("profile", model1);}
			model.addAttribute("User", new UserMaster());
			return new ModelAndView("signin");
	}
}
