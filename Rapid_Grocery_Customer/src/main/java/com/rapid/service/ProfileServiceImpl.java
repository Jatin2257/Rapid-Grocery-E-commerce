package com.rapid.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rapid.dao.ProfileDao;
import com.rapid.dao.UserDao;
import com.rapid.bean.UserMasterBean;
import com.rapid.model.UserMaster;

@Service("profileService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class ProfileServiceImpl  implements ProfileService{
	
	@Autowired
	private ProfileDao profileDao;

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(UserMasterBean userMaster) {
		profileDao.addUser(userMaster);
	}

	@Override
	public UserMaster listUser(Integer Id) {
		return profileDao.listUser(Id);
	}
	@Override
	public UserMaster getUser(Integer userMasterId) {
		return profileDao.getUser(userMasterId);
	}
	
	@Override
	public UserMaster adduser1() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	

}

