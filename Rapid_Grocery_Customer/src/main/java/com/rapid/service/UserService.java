package com.rapid.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;


import com.rapid.bean.UserMasterBean;


import com.rapid.model.UserMaster;

@Service
public interface UserService {

	public void addUser(UserMasterBean userMaster);
	
	public List<UserMaster> listUser();
	
	public void deleteUser(Integer userMasterId);

	public UserMaster getUser(Integer userMasterId);
	
	public void updateActiveUser(Integer userMasterId);

	public Boolean checkLogin(UserMasterBean userMaster, HttpSession session);
}

