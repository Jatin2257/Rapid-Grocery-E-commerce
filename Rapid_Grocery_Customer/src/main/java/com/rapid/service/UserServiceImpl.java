package com.rapid.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



import com.rapid.bean.UserMasterBean;

import com.rapid.dao.UserDao;

import com.rapid.model.UserMaster;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	//add Category
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(UserMasterBean userMaster) {
		userDao.addUser(userMaster);
	}

	@Override
	public List<UserMaster> listUser() {
		return userDao.listUser();
	}

	@Override
	@Transactional
	public void deleteUser(Integer userMasterId) {
		userDao.deleteUser(userMasterId);
	}
//
	@Override
	public UserMaster getUser(Integer userMasterId) {
		return userDao.getUser(userMasterId);
	}

	@Override
	@Transactional
	public void updateActiveUser(Integer userMasterId) {
		userDao.updateActiveUser(userMasterId);
	}

	@Override
	public Boolean checkLogin(UserMasterBean userMaster, HttpSession session) {		
		return userDao.checkLogin(userMaster, session);
	}

	

	
	
		
}

