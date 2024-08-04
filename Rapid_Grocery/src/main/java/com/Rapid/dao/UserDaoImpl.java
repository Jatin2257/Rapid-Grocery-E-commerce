package com.Rapid.dao;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.Rapid.bean.LoggerInfo;

import com.Rapid.bean.UserMasterBean;

import com.Rapid.model.UserMaster;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	GeneralImp generalImp;

	@SuppressWarnings("unchecked")
	public void addUser(UserMasterBean userMaster) {
		UserMaster user = covertFomBeanToModel(userMaster);
		// sessionFactory.getCurrentSession().saveOrUpdate(user);
		generalImp.create(user, sessionFactory);
	}

	private UserMaster covertFomBeanToModel(UserMasterBean userMaster) {
		UserMaster user = new UserMaster();
		user.setUserMasterId(userMaster.getUserMasterId());
		user.setUserMasterFirstName(userMaster.getUserMasterFirstName());
		user.setUserMasterLastName(userMaster.getUserMasterLastName());
		user.setUserEmailId(userMaster.getUserEmailId());
		user.setUserAddress(userMaster.getUserAddress());
		user.setUserContact(userMaster.getUserContact());
		user.setUserDOB(userMaster.getUserDOB());
		user.setUserPassword(userMaster.getUserPassword());
		user.setUserTId(userMaster.getUserTId());
		user.setUserSalary(userMaster.getUserSalary());
		user.setIsActive(userMaster.getIsActive());
		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserMaster> listUser() {

		String sqlQuery = "SELECT um.userMasterId,um.userMasterFirstName,um.userMasterLastName,um.userEmailId,"
				+ "um.userContact,um.userAddress,um.userPassword,um.userDOB,um.userTId, um.isActive"
				+ ",ut.userTId,ut.userTName from UserMaster um "
				+ " INNER JOIN UserType ut ON ut.userTId = um.userTId";

		List<UserMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);

		return list;
	}

	
	
//
//	@Override
	public void deleteUser(Integer userMasterId) {
		String hqlQueryString = "DELETE FROM UserMaster WHERE userMasterId = " + userMasterId;
		generalImp.deleteByHQL(hqlQueryString, sessionFactory);
	}

//	@Override
	public UserMaster getUser(Integer userMasterId) {
		return (UserMaster) generalImp.getById(UserMaster.class, userMasterId, sessionFactory);
	}

	public void updateActiveUser(Integer userMasterId) {
		UserMaster userMaster = (UserMaster) generalImp.getById(UserMaster.class, userMasterId, sessionFactory);
//		if(Integer.parseInt(userMaster.getIsActive()) == 0) {
//			userMaster.setIsActive("1");
//		} else {
//			userMaster.setIsActive("0");
//		}

		userMaster.setUserMasterId(userMasterId);
		String hqlQueryString = "";
		if (userMaster.getIsActive().equals("Active")) {
			userMaster.setIsActive("InActive");
			hqlQueryString = "UPDATE FROM UserMaster set isActive = 'InActive' WHERE userMasterId = " + userMasterId;
		} else {
			userMaster.setIsActive("Active");
			hqlQueryString = "UPDATE FROM UserMaster set isActive = 'Active' WHERE userMasterId = " + userMasterId;
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

	@Override
	public Long countofUsers() {
		String sqlString = "SELECT COUNT(userMasterId) from UserMaster";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sqlString);
		Iterator count = query.iterate();
		// System.out.println("No. of rows : "+count.next());
		Long i = (Long) count.next();
		return i;
	}

	@Override
	public Long countofEmp() {
		String sqlString = "Select count(userMasterId) from UserMaster where userTId=2 or userTId=4";
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(sqlString);
		Iterator count = query.iterate();
		// System.out.println("No. of rows : "+count.next());
		Long i = (Long) count.next();
		return i;
	}

	@Override
	public Boolean checkLogin(UserMasterBean userMaster, HttpSession session) {

		LoggerInfo loggerInfo = new LoggerInfo();
		
		Integer userMasterId = 0;
		String userMasterFirstName = null;
		String userMasterLastName = null;
		String userEmailId = userMaster.getUserEmailId();
		String userAddress = null;
		Long userContact = null;		
		String userPassword = userMaster.getUserPassword();
		Integer userTId = 0;
		String userEmailIdDB = null;
		String userPasswordDB = null;
		String activeStatus = null;
		String activeStatusValue = "Active";
		
		
		String sqlQueryEmail = "SELECT userEmailId, userPassword, userAddress, userContact, userDOB, userTId, userMasterFirstName, "
				+ "userMasterLastName, userMasterId, isActive from UserMaster where userEmailId = '"+ userEmailId + "'";
		
		String sqlQuery = "SELECT userEmailId, userPassword, userAddress, userContact, userDOB, userTId, userMasterFirstName, "
				+ "userMasterLastName, userMasterId, isActive from UserMaster where userEmailId = '" + userEmailId
				+ "' and userPassword='" + userPassword + "'";

		@SuppressWarnings("unchecked")
		List<UserMaster> list1 = generalImp.getListByHQL(sqlQueryEmail, sessionFactory);
		@SuppressWarnings("unchecked")
		List<UserMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			
			userMasterId = Integer.parseInt(String.valueOf(obj[8]));
			userMasterFirstName = String.valueOf(obj[6]);
			userMasterLastName = String.valueOf(obj[7]);
			userAddress = String.valueOf(obj[2]);
			String number = String.valueOf(obj[3]);
			userContact = Long.parseLong(number);
			userEmailIdDB = String.valueOf(obj[0]);
			userPasswordDB = String.valueOf(obj[1]);
			userTId = Integer.parseInt(String.valueOf(obj[5]));
			activeStatus = String.valueOf(obj[9]);
		}
		
		if (userEmailIdDB == null || !(userEmailId.equals(userEmailIdDB))) {
			session.setAttribute("error", "InValid Email Address");
			return false;
		}
		if (!(activeStatusValue.equals(activeStatus))) {
			session.setAttribute("error2", "Your Account is Current InActive.!Please Contact Your Admin");
			return false;
		}
		if (!(userTId==1 || userTId==2 || userTId==4)) {
			session.setAttribute("error2", "You'r Not a valid person to login into this system");
			return false;
		}
		if (userPassword == null || !(userPassword.equals(userPasswordDB))) {
			session.setAttribute("error1", "Check Your Password Once");
			return false;
		}
		if ((userEmailId.equals(userEmailIdDB) && userPassword.equals(userPasswordDB))) {
			loggerInfo.setUserMasterId(userMasterId);
			loggerInfo.setUserMasterFirstName(userMasterFirstName);
			loggerInfo.setUserMasterLastName(userMasterLastName);
			loggerInfo.setUserAddress(userAddress);
			loggerInfo.setUserContact(userContact);
			loggerInfo.setUserEmailId(userEmailIdDB);
			loggerInfo.setUserPassword(userPasswordDB);
			loggerInfo.setUserTId(userTId);
			
			session.setAttribute("LoggerInfo", loggerInfo);	
			session.setAttribute("name", userMasterFirstName);
			return true;
		}
		return false;
	}

}
