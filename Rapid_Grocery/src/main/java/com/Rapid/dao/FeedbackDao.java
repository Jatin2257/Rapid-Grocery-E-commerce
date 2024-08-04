package com.Rapid.dao;

import java.util.List;

import com.Rapid.model.FeedbackTable;

public interface FeedbackDao {

	public List<FeedbackTable> listFeedbacks();

	public Long feedbackcount();
}
