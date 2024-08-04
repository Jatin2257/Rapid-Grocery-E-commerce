package com.Rapid.dao;

import java.util.List;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.bean.UserMasterBean;
import com.Rapid.bean.UserSalaryBean;
import com.Rapid.model.Category;
import com.Rapid.model.SubproductMaster;
import com.Rapid.model.UserMaster;
import com.Rapid.model.UserSalary;

public interface UserSalaryDao {
	
	public void addSalary(UserSalaryBean userSalary);
	
	public List<UserSalary> listUserSalary();
		
	public void deleteSalary(Integer userSalaryId);

	//public UserSalary getSalary(Integer userMasterId,Integer userSalary);
	
	public void updatePaidSalary(Integer userSalaryId);
}
