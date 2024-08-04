package com.Rapid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Rapid.bean.UserMasterBean;
import com.Rapid.dao.EmployeeDao;
import com.Rapid.model.UserMaster;

@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(UserMasterBean employeeBean) {
		employeeDao.addEmployee(employeeBean);
	}

	@Override
	public List<UserMaster> listEmployee() {
		return employeeDao.listEmployee();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer userMasterId) {
		employeeDao.deleteEmployee(userMasterId);
	}

	@Override
	public UserMaster getEmployee(Integer userMasterId) {
		return employeeDao.getEmployee(userMasterId);
	}
	
	
}
