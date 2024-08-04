package com.Rapid.dao;

import com.Rapid.bean.UserMasterBean;
import com.Rapid.model.UserMaster;

public interface ProfileDao {
	
public void  addUser(UserMasterBean userMaster);
	
	public UserMaster listUser(Integer Id);

	public UserMaster getUser(Integer userMasterId);
	
		

}
