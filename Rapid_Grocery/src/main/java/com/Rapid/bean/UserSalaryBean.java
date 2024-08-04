package com.Rapid.bean;

import java.util.Date;

public class UserSalaryBean {
	
	private Integer userSalaryId;
	private Integer userMasterId;
	private Integer userSalary;//have given two same names
	private Date userSalaryDate;
	private String isPaid;
	 //date util
	
	public Date getUserSalaryDate() {
		return userSalaryDate;
	}

	public void setUserSalaryDate(Date userSalaryDate) {
		this.userSalaryDate = userSalaryDate;
	}


	
	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}



	public Integer getUserSalary() {
		return userSalary;
	}

	public void setUserSalary(Integer userSalary) {
		this.userSalary = userSalary;
	}

	public Integer getUserSalaryId() {
		return userSalaryId;
	}

	public void setUserSalaryId(Integer userSallaryId) {
		this.userSalaryId = userSallaryId;
	}

	public Integer getUserMasterId() {
		return userMasterId;
	}

	public void setUserMasterId(Integer userMasterId) {
		this.userMasterId = userMasterId;
	}

	
}
