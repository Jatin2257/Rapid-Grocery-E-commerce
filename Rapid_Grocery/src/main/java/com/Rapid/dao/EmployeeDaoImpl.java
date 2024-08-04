package com.Rapid.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Rapid.bean.UserMasterBean;
import com.Rapid.model.UserMaster;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Autowired
	GeneralImp generalImp;
	
	@Override
	public void addEmployee(UserMasterBean employeeBean) {
		UserMaster userMaster = covertFomBeanToModel(employeeBean);
//		generalImp.create(userMaster, sessionFactory);
		sessionFactory.getCurrentSession().saveOrUpdate(userMaster);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserMaster> listEmployee() {
		String sqlQuery = "SELECT um.userMasterId,um.userMasterFirstName,um.userMasterLastName,um.userEmailId,"
				+ "um.userContact,um.userAddress,um.userPassword,um.userDOB,um.userTId, um.isActive,"
				+ "ut.userTId,ut.userTName from UserMaster um "
				+ " INNER JOIN UserType ut ON ut.userTId = um.userTId";

		List<UserMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);
		System.out.println(list);
		return list;
	}
	
	@Override
	public void deleteEmployee(Integer userMasterId) {
		String hqlQuery = "DELETE FROM UserMaster WHERE user_master_id = "+userMasterId;
		generalImp.deleteByHQL(hqlQuery, sessionFactory);
	}
	
	private UserMaster covertFomBeanToModel(UserMasterBean employeeBean) {
		UserMaster userMaster = new UserMaster();
		userMaster.setUserMasterId(employeeBean.getUserMasterId());
		userMaster.setUserMasterFirstName(employeeBean.getUserMasterFirstName());
		userMaster.setUserMasterLastName(employeeBean.getUserMasterLastName());
		userMaster.setIsActive("Active");
		userMaster.setIsPaid("NotPaid");
		userMaster.setUserEmailId(employeeBean.getUserEmailId());
		userMaster.setUserAddress(employeeBean.getUserAddress());
		userMaster.setUserContact(employeeBean.getUserContact());
		userMaster.setUserDOB(employeeBean.getUserDOB());
		userMaster.setUserPassword(employeeBean.getUserPassword());
		userMaster.setUserTId(employeeBean.getUserTId());
		userMaster.setUserSalary(employeeBean.getUserSalary());
		return userMaster;
	}

	@Override
	public UserMaster getEmployee(Integer userMasterId) {
		return (UserMaster) generalImp.getById(UserMaster.class, userMasterId, sessionFactory);
	}

}
