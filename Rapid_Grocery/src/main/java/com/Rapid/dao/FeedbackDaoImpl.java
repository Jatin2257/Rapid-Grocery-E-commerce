package com.Rapid.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Rapid.model.FeedbackTable;

@Repository("feedbackDao")
public class FeedbackDaoImpl implements FeedbackDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	GeneralImp generalImp;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<FeedbackTable> listFeedbacks() {
		String sqlString = "Select fb.feedbackId,fb.feedbackMessage,fb.feedbackDate,fb.userMasterId,um.userMasterId,um.userMasterFirstName,um.userMasterLastName FROM FeedbackTable as fb "
				+"INNER JOIN UserMaster um ON fb.userMasterId =um.userMasterId"
				
				;
		List<FeedbackTable> list = generalImp.getListByHQL(sqlString, sessionFactory);
		return list;
		//return (List<FeedbackTable>) sessionFactory.getCurrentSession().createCriteria(FeedbackDao.class).list();
	}
	
	@Override
	public Long feedbackcount() {
		long millis=System.currentTimeMillis();   
	    java.sql.Date date = new java.sql.Date(millis);       
	   
	    String sqlString="SELECT count(feedbackId) FROM FeedbackTable where feedbackDate= '"+date+"'";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sqlString);
		Iterator count = query.iterate();
		//System.out.println("No. of rows : "+count.next()); 
		Long i = (Long) count.next();
		System.out.println(i);
		return i;
	}

}
