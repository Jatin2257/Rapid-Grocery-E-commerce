package com.Rapid.dao;

import java.util.List;

import com.Rapid.bean.UserMasterBean;
import com.Rapid.model.UserMaster;

public interface EmployeeDao {

	public void addEmployee(UserMasterBean employeeBean);

	public List<UserMaster> listEmployee();

	public void deleteEmployee(Integer userMasterId);

	public UserMaster getEmployee(Integer userMasterId);

}
