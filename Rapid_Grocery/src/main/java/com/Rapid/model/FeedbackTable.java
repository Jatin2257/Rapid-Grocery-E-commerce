package com.Rapid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "feedback_table")
public class FeedbackTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	public Integer feedbackId;
	
	@Column(name = "feedback_message")
	public String feedbackMessage;
	
	@Column(name = "feedback_date")
	public Date feedbackDate;
	
	@Column(name = "user_master_id")
	public Integer userMasterId;
	
	@Transient
	@Column(name = "user_first_name")
	private String userMasterFirstName;
	
	@Transient
	@Column(name = "user_last_name")
	private String userMasterLastName;

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

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackMessage() {
		return feedbackMessage;
	}

	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}

	public Date getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public Integer getUserMasterId() {
		return userMasterId;
	}

	public void setUserMasterId(Integer userMasterId) {
		this.userMasterId = userMasterId;
	}
}
