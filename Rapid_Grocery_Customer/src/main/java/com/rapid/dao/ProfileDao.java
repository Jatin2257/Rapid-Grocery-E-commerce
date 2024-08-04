package com.rapid.dao;


import javax.servlet.http.HttpSession;

import com.rapid.bean.UserMasterBean;
import com.rapid.model.UserMaster;

public interface ProfileDao {
	
public void  addUser(UserMasterBean userMaster);
	
	public UserMaster listUser(Integer Id);

	public UserMaster getUser(Integer userMasterId);
	
		

}
