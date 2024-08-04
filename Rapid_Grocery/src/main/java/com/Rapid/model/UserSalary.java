package com.Rapid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_sallary")
public class UserSalary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_salary_id")
	private Integer userSalaryId;
	
	@Column(name = "user_master_id")
	private Integer userMasterId; //have given two same names
	
	@Column(name = "user_salary")
	private Integer userSalary;
	
	@Column(name = "user_salary_date")
	private Date userSalaryDate; //date util

	
	
	
	//have given two same names
	@Column(name = "ispaid")
	private String isPaid;




	public Integer getUserSalaryId() {
		return userSalaryId;
	}




	public void setUserSalaryId(Integer userSalaryId) {
		this.userSalaryId = userSalaryId;
	}




	public Integer getUserMasterId() {
		return userMasterId;
	}




	public void setUserMasterId(Integer userMasterId) {
		this.userMasterId = userMasterId;
	}




	public Integer getUserSalary() {
		return userSalary;
	}




	public void setUserSalary(Integer userSalary) {
		this.userSalary = userSalary;
	}




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
	
	
}
