package com.Rapid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.bean.UserMasterBean;
import com.Rapid.bean.UserSalaryBean;
import com.Rapid.dao.CategoryDao;
import com.Rapid.dao.CategoryDaoImpl;
import com.Rapid.dao.SubProductDao;
import com.Rapid.dao.UserDao;
import com.Rapid.dao.UserSalaryDao;
import com.Rapid.model.Category;
import com.Rapid.model.SubproductMaster;
import com.Rapid.model.UserMaster;
import com.Rapid.model.UserSalary;

@Service("salaryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SalaryServiceImpl implements SalaryService {
	@Autowired
	private UserSalaryDao userSalaryDao;

	
	
	
	//add Category
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSalary(UserSalaryBean userMaster) {
		userSalaryDao.addSalary(userMaster);
	}

	@Override
	public List<UserSalary> listUserSalary() {
		return userSalaryDao.listUserSalary();
	}
//
	@Override
	@Transactional
	public void deleteSalary(Integer userSalaryId) {
		userSalaryDao.deleteSalary(userSalaryId);
	}
////
//	@Override
//	public UserSalary getSalary(Integer userMasterId,Integer userSalary) {
//		return userSalaryDao.getSalary(userMasterId, userSalary);
//	}

	@Override
	@Transactional
	public void updatePaidSalary(Integer userSalaryId) {
		userSalaryDao.updatePaidSalary(userSalaryId);
	}

	

	
	
		
}
