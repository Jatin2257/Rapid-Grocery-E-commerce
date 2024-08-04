package com.Rapid.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Rapid.bean.LoggerInfo;
import com.Rapid.bean.UserMasterBean;
import com.Rapid.model.UserMaster;

@Repository("profileDao")
public class ProfileDaoImpl implements ProfileDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Autowired
	GeneralImp generalImp;
	
	@Autowired
	HttpSession session;

	
	public void addUser(UserMasterBean userMaster) {
		UserMaster user = covertFomBeanToModel(userMaster);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
//		generalImp.modify(user, sessionFactory);
	}

	private UserMaster covertFomBeanToModel(UserMasterBean userMaster) {
		UserMaster user = new UserMaster();
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");	
		
		String sqlQuery = "SELECT userPassword, userDOB, userTId, userMasterId, isActive "
				+ "from UserMaster where userMasterId = "+loggerInfo.getUserMasterId();
		@SuppressWarnings("unchecked")
		List<UserMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);
		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
		
			user.setUserMasterId(userMaster.getUserMasterId());
			user.setUserMasterFirstName(userMaster.getUserMasterFirstName());
			user.setUserMasterLastName(userMaster.getUserMasterLastName());
			user.setUserEmailId(userMaster.getUserEmailId());
			user.setUserAddress(userMaster.getUserAddress());
			user.setUserContact(userMaster.getUserContact());	
			user.setIsActive(String.valueOf(obj[4]));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 
		    Date date=null;
			try {
				date = formatter.parse(String.valueOf(obj[1]));
			} catch (ParseException e) {				
				e.printStackTrace();
			}
			user.setUserDOB(date);
			user.setUserPassword(String.valueOf(obj[0]));			
			user.setUserTId(Integer.parseInt(String.valueOf(obj[2])));
			
		}
		return user;
	}
	
	@Override
	public UserMaster listUser(Integer Id) {
		return (UserMaster)generalImp.getById(UserMaster.class, Id, sessionFactory);
	}
	@Override
	public UserMaster getUser(Integer userMasterId) {
		return (UserMaster) generalImp.getById(UserMaster.class, userMasterId, sessionFactory);
	}
}

	

