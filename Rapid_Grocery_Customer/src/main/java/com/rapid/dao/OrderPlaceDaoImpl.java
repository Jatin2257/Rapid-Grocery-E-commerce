package com.rapid.dao;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.rapid.bean.LoggerInfo;
import com.rapid.bean.OrderPlaceBean;
import com.rapid.model.OrderPlace;

@Repository("orderplaceDao")
public class OrderPlaceDaoImpl implements OrderPlaceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	GeneralImp generalImp;

	
	@Autowired
	HttpSession session;
	

	@Override
	@SuppressWarnings("unchecked")
	public List<OrderPlace> listOrder() {
		
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		int id = loggerInfo.getUserId();
//		int id = 22;
		String sqlQuery = "SELECT OP.OrderId, OP.cartId, OP.OrderStatusId, OP.userMasterId, OP.billingAddress, OP.shippingAddress, OP.totalAmount,"
				+ "OS.OrderStatusId, OS.OrderStatusName, UM.userMasterId, UM.userMasterFirstName, UM.userMasterLastName, OP.orderDate"
				+ " FROM OrderPlace OP INNER JOIN OrderStatus OS ON OS.OrderStatusId = OP.OrderStatusId INNER JOIN UserMaster UM ON (UM.userMasterId = OP.userMasterId) where UM.userMasterId= "+id;
		
		System.out.println(id);
		List<OrderPlace> list = generalImp.getListByHQL(sqlQuery, sessionFactory);
		System.out.println(list);
		return list;
		
		
		
	}
//
////
////	@Override
//	public void deleteUser(Integer userMasterId) {
//		String hqlQueryString = "DELETE FROM UserMaster WHERE userMasterId = " + userMasterId;
//		generalImp.deleteByHQL(hqlQueryString, sessionFactory);
//	}
	
	
	@Override
	public OrderPlace getOrder(Integer userMasterId) {
		return (OrderPlace) generalImp.getById(OrderPlace.class, userMasterId, sessionFactory);
	}	
}
