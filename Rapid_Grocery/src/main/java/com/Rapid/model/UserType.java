package com.Rapid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_type_master")
public class UserType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_type_id")
	private Integer userTId;

	@Column(name = "user_type_name")
	private String userTName;

	public Integer getUserTId() {
		return userTId;
	}

	public void setUserTId(Integer userTId) {
		this.userTId = userTId;
	}

	public String getUserTName() {
		return userTName;
	}

	public void setUserTName(String userTName) {
		this.userTName = userTName;
	}

}
