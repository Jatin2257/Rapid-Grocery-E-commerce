package com.Rapid.service;

import java.util.List;

import com.Rapid.model.FeedbackTable;

public interface FeedbackService {

	public List<FeedbackTable> listFeedbacks();

	public Long feedbackcount();
}
