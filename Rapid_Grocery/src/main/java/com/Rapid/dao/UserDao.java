package com.Rapid.dao;

import java.util.List;

import javax.servlet.http.HttpSession;
import com.Rapid.bean.UserMasterBean;
import com.Rapid.model.UserMaster;

public interface UserDao {
	
	public void addUser(UserMasterBean userMaster);
	
	public List<UserMaster> listUser();
//	
	public void deleteUser(Integer userMasterId);

	public UserMaster getUser(Integer userMasterId);
	
	public void updateActiveUser(Integer userMasterId);
	
	public Long countofUsers();
	
	public Long countofEmp();
	
	public Boolean checkLogin(UserMasterBean userMaster, HttpSession session);
}
