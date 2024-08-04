package com.Rapid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Rapid.bean.UserSalaryBean;
import com.Rapid.model.UserSalary;


@Service
public interface SalaryService {

	public void addSalary(UserSalaryBean userMaster);
	
	public List<UserSalary> listUserSalary();
	
	public void deleteSalary(Integer userSalaryId);
//
//	public UserSalary getSalary(Integer userMasterId,Integer userSalary);
//	
	public void updatePaidSalary(Integer userSalaryId);


}
