package com.rapid.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_master")
public class UserMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_master_id")
	private Integer userMasterId;
	
	@Column(name = "user_first_name")
	private String userMasterFirstName;
	
	@Column(name = "user_last_name")
	private String userMasterLastName;
	
	@Column(name = "user_email_id")
	private String userEmailId;
	
	@Column(name = "user_address")
	private String userAddress;
	
	@Column(name = "user_contact")
	private Long userContact;
	
	
	@Column(name = "user_dob")
	private Date userDOB; //sql date formate
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_type_id")
	private Integer userTId; //fk
	
	@Column(name = "user_salary")
	private Integer userSalary;

	@Column(name = "user_active_status")
	private String isActive;
	
	private Integer userSalaryId;
	
	private String isPaid;
	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public Integer getUserSalaryId() {
		return userSalaryId;
	}

	@Column(name = "user_salary_id")
	public void setUserSalaryId(Integer userSalaryId) {
		this.userSalaryId = userSalaryId;
	}
	
	
	
	private String userTypeName;

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
