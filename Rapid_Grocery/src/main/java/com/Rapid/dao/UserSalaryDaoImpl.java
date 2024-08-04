package com.Rapid.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.Rapid.bean.UserMasterBean;
import com.Rapid.bean.UserSalaryBean;
import com.Rapid.model.UserMaster;
import com.Rapid.model.UserSalary;

@Repository("userSalaryDao")
public class UserSalaryDaoImpl implements UserSalaryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Autowired
	GeneralImp generalImp;

	@Override
	@SuppressWarnings("unchecked")
	public void addSalary(UserSalaryBean userSalary) {
		UserMaster userMaster = (UserMaster) generalImp.getById(UserMaster.class,userSalary.getUserMasterId() , sessionFactory);
		
		System.out.println(userMaster.getUserSalary());
		userSalary.setIsPaid("Paid");
		userSalary.setUserSalary(userMaster.getUserSalary());
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		 
		// Set time fields to zero
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		 
		// Put it back in the Date object
		date = cal.getTime();
		   userSalary.setUserSalaryDate(date);
		UserSalary user = covertFomBeanToModel(userSalary);
		 sessionFactory.getCurrentSession().saveOrUpdate(user);
		//generalImp.create(user, sessionFactory);
	}

	private UserSalary covertFomBeanToModel(UserSalaryBean userMaster) {
		UserSalary user = new UserSalary();
		user.setUserMasterId(userMaster.getUserMasterId());
		user.setUserSalaryId(userMaster.getUserSalaryId());
		user.setUserSalary(userMaster.getUserSalary());
		user.setUserSalaryDate(userMaster.getUserSalaryDate());
		user.setIsPaid(userMaster.getIsPaid());
		
		return user;
	}

	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<UserSalary> listUserSalary() {
		return (List<UserSalary>) sessionFactory.getCurrentSession().createCriteria(UserSalary.class).list();
	}

////
	@Override
	public void deleteSalary(Integer userSalaryId) {
		String hqlQueryString = "DELETE FROM UserMaster WHERE userMasterId = " + userSalaryId;
		generalImp.deleteByHQL(hqlQueryString, sessionFactory);
	}
//
//	@Override
//	public UserSalary getSalary(Integer userMasterId) {
//		return (UserSalary) generalImp.getById(UserSalary.class, userMasterId, sessionFactory);
//	}

	public void updatePaidSalary(Integer userSalaryId) {
		UserSalary userSalary = (UserSalary) generalImp.getById(UserSalary.class, userSalaryId, sessionFactory);
//		if(Integer.parseInt(userMaster.getIsActive()) == 0) {
//			userMaster.setIsActive("1");
//		} else {
//			userMaster.setIsActive("0");
//		}

		userSalary.setUserSalaryId(userSalaryId);
		String hqlQueryString = "";
		if (userSalary.getIsPaid().equals("NotPaid")) {
			userSalary.setIsPaid("Paid");
			hqlQueryString = "UPDATE FROM UserMaster set isPaid = 'Paid' WHERE userSalaryId = "
					+ userSalaryId;
		} 

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hqlQueryString);
		query.executeUpdate();
		// System.out.println(hqlQueryString);
//		sessionFactory.getCurrentSession().saveOrUpdate(userMaster);
		// generalImp.modify(hqlQueryString, sessionFactory);
		// Session session = sessionFactory.getCurrentSession();
		// session.update(userMaster);
		// generalImp.modify(userMaster, sessionFactory);
//		System.out.println("done");
//		return (UserMaster) generalImp.getById(UserMaster.class, userMasterId, sessionFactory);

	}

	

}
