package com.rapid.dao;

import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rapid.bean.UserMasterBean;
import com.rapid.model.UserMaster;

@Repository("profileDao")
public class ProfileDaoImpl implements ProfileDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Autowired
	GeneralImp generalImp;

	
	public void addUser(UserMasterBean userMaster) {
		UserMaster user = covertFomBeanToModel(userMaster);
		// sessionFactory.getCurrentSession().saveOrUpdate(user);
		generalImp.modify(user, sessionFactory);
	}

	private UserMaster covertFomBeanToModel(UserMasterBean userMaster) {
		UserMaster user = new UserMaster();
		user.setUserMasterId(userMaster.getUserMasterId());
		user.setUserMasterFirstName(userMaster.getUserMasterFirstName());
		user.setUserMasterLastName(userMaster.getUserMasterLastName());
		user.setUserEmailId(userMaster.getUserEmailId());
		user.setUserAddress(userMaster.getUserAddress());
		user.setUserContact(userMaster.getUserContact());
		user.setUserPassword(userMaster.getUserPassword());
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

	

