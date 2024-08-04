package com.Rapid.service;

import org.springframework.stereotype.Service;
import com.Rapid.bean.UserMasterBean;
import com.Rapid.model.UserMaster;

@Service
public interface ProfileService {
		
	public void addUser(UserMasterBean userMaster);

	
	public UserMaster listUser(Integer Id);
	

	public UserMaster getUser(Integer userMasterId);

	
	

	public UserMaster adduser1();


	

	
	//public void addUser(UserMasterBean userMaster);
		
}
