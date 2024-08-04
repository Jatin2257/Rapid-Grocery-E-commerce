package com.rapid.bean;

import java.sql.Date;

public class UserMasterBean {
	private Integer userMasterId;
	private String userMasterFirstName;
	private String userMasterLastName;
	private String userEmailId;
	private String userAddress;
	private Long userContact;
	private Date userDOB; //sql date formate
	private String userPassword;
	private Integer userTId; //two var has same name
	private Integer userSalaryId;
	public Integer getUserSalaryId() {
		return userSalaryId;
	}

	public void setUserSalaryId(Integer userSalaryId) {
		this.userSalaryId = userSalaryId;
	}

	private Integer userSalary;
	private String isActive;
	private String userTypeName;
	private String isPaid;

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Integer getUserSalary() {
		return userSalary;
	}

	public void setUserSalary(Integer userSalary) {
		this.userSalary = userSalary;
	}

	public Integer getUserMasterId() {
		return userMasterId;
	}

	public void setUserMasterId(Integer userMasterId) {
		this.userMasterId = userMasterId;
	}

	public String getUserMasterFirstName() {
		return userMasterFirstName;
	}

	public void setUserMasterFirstName(String userMasterFirstName) {
		this.userMasterFirstName = userMasterFirstName;
	}

	public String getUserMasterLastName() {
		return userMasterLastName;
	}

	public void setUserMasterLastName(String userMasterLastName) {
		this.userMasterLastName = userMasterLastName;
	}

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Long getUserContact() {
		return userContact;
	}

	public void setUserContact(Long userContact) {
		this.userContact = userContact;
	}

	public Date getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserTId() {
		return userTId;
	}

	public void setUserTId(Integer userTId) {
		this.userTId = userTId;
	}


}

