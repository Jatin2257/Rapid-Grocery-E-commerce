package com.Rapid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Rapid.dao.FeedbackDao;
import com.Rapid.model.FeedbackTable;

@Service("feedbackService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackDao feedbackDao;
	
	@Override
	public List<FeedbackTable> listFeedbacks() {
		return feedbackDao.listFeedbacks();
	}
	
	@Override
	public Long feedbackcount() {
		return feedbackDao.feedbackcount();
	}

}
