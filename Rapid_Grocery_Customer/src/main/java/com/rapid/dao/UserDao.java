package com.rapid.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.rapid.bean.UserMasterBean;


import com.rapid.model.UserMaster;

public interface UserDao {
	
	public void addUser(UserMasterBean userMaster);
	
	public List<UserMaster> listUser();
//	
	public void deleteUser(Integer userMasterId);

	public UserMaster getUser(Integer userMasterId);
	
	public void updateActiveUser(Integer userMasterId);
	
	public Boolean checkLogin(UserMasterBean userMaster, HttpSession session);
}

