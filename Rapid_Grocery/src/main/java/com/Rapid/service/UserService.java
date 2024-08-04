package com.Rapid.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.Rapid.bean.CategoryBean;

import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.bean.UserMasterBean;
import com.Rapid.model.Category;
import com.Rapid.model.SubproductMaster;
import com.Rapid.model.UserMaster;

@Service
public interface UserService {

	public void addUser(UserMasterBean userMaster);
	
	public List<UserMaster> listUser();
	
	public void deleteUser(Integer userMasterId);

	public UserMaster getUser(Integer userMasterId);
	
	public void updateActiveUser(Integer userMasterId);

	public Long countofUsers();
	public Long countofEmp();
	public Boolean checkLogin(UserMasterBean userMaster, HttpSession session);
}
