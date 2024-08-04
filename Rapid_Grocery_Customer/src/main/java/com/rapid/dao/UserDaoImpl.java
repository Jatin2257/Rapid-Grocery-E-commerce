package com.rapid.dao;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapid.bean.LoggerInfo;
import com.rapid.bean.UserMasterBean;
import com.rapid.model.UserMaster;

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
		user.setIsActive("Active");
		user.setUserSalary(userMaster.getUserSalary());
		return user;
	}

	@Override
	 @SuppressWarnings("unchecked") 
	public List<UserMaster> listUser() {

		String sqlQuery = "SELECT um.userMasterId,um.userMasterFirstName,um.userMasterLastName,um.userEmailId,"
				+ "um.userContact,um.userAddress,um.userPassword,um.userDOB,um.userTId, um.isActive,um.userSalaryId,"
				+ "us.userSalaryId,us.userSalary,us.isPaid,ut.userTId,ut.userTName from UserMaster um "
				+ "INNER JOIN UserSalary us ON um.userMasterId = us.userMasterId"
				+ " INNER JOIN UserType ut ON ut.userTId = um.userTId";

		
		List<UserMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);
		return list;
	}

	@Override
	public void deleteUser(Integer userMasterId) {
		String hqlQueryString = "DELETE FROM UserMaster WHERE userMasterId = " + userMasterId;
		generalImp.deleteByHQL(hqlQueryString, sessionFactory);
	}

	@Override
	public UserMaster getUser(Integer userMasterId) {
		return (UserMaster) generalImp.getById(UserMaster.class, userMasterId, sessionFactory);
	}

	public void updateActiveUser(Integer userMasterId) {
		UserMaster userMaster = (UserMaster) generalImp.getById(UserMaster.class, userMasterId, sessionFactory);
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

	}

	@Override
	public Boolean checkLogin(UserMasterBean userMaster, HttpSession session) {
		
		LoggerInfo loggerInfo = new LoggerInfo();
		
		String email = userMaster.getUserEmailId();
		String password = userMaster.getUserPassword();
		String emaildb = null;
		String passworddb = null;
		String firstname = null;
		Integer userIdInteger = null;
		
		String sqlQuery = "SELECT userEmailId, userPassword, userMasterFirstName, userMasterId from UserMaster where userEmailId = '" + email
				+ "' and userPassword='" + password + "'";
		@SuppressWarnings("unchecked")
		List<UserMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);
		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			emaildb = String.valueOf(obj[0]);
			passworddb = String.valueOf(obj[1]);
			firstname = String.valueOf(obj[2]);
			userIdInteger = Integer.parseInt(String.valueOf(obj[3]));
		}
		if (emaildb == null) return false;
		if (email.equals(emaildb) && password.equals(passworddb)) {
			
			loggerInfo.setUserId(userIdInteger);
			loggerInfo.setUserName(firstname);
			loggerInfo.setUserEmail(emaildb);
			session.setAttribute("LoggerInfo", loggerInfo);	
			session.setAttribute("Id", userIdInteger);
			return true;
		}
		return false;
	}
}
