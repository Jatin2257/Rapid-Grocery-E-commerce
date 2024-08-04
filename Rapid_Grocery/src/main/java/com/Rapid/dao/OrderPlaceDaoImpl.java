package com.Rapid.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.Rapid.bean.OrderPlaceBean;
import com.Rapid.model.OrderPlace;

@Repository("orderplaceDao")
public class OrderPlaceDaoImpl implements OrderPlaceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	GeneralImp generalImp;
//
	@SuppressWarnings("unchecked")
	public void addOrder(OrderPlaceBean orderplace) {
		OrderPlace order = covertFomBeanToModel(orderplace);
		// sessionFactory.getCurrentSession().saveOrUpdate(user);
		generalImp.create(order, sessionFactory);
	}

	private OrderPlace covertFomBeanToModel(OrderPlaceBean orderplace) {
		OrderPlace order = new OrderPlace();
		
		order.setOrderStatusId(orderplace.getOrderStatusId());
		return order;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<OrderPlace> listOrder() {

		String sqlQuery = "SELECT OP.orderId, OP.cartId, OP.orderStatusId, OP.userMasterId, OP.billingAddress, OP.shippingAddress, OP.totalAmount,"
		+ "OS.orderStatusId, OS.orderStatusName, UM.userMasterId, UM.userMasterFirstName, UM.userMasterLastName, OP.orderDate"
		+ " FROM OrderPlace OP INNER JOIN OrderStatus OS ON OS.orderStatusId = OP.orderStatusId INNER JOIN UserMaster UM ON (UM.userMasterId = OP.userMasterId)";
		
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
//
////	@Override
	public OrderPlace getOrder(Integer userMasterId) {
		return (OrderPlace) generalImp.getById(OrderPlace.class, userMasterId, sessionFactory);
	}
//
	public void updateOrderStatus(Integer orderId) {
		OrderPlace orderplace = (OrderPlace) generalImp.getById(OrderPlace.class, orderId, sessionFactory);
		orderplace.setOrderId(orderId);
		int i = (Integer) orderplace.getOrderStatusId(); 
		String hqlQueryString = "";
		if (!(orderplace.getOrderStatusId()== 6)) {
			++i;
			hqlQueryString = "UPDATE FROM OrderPlace set orderStatusId = "+(i)+" WHERE orderId = " + orderId;
		} 
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hqlQueryString);
		query.executeUpdate();
		
	}
	
	
	public void cancelOrderStatus(Integer orderId) {
		String hqlQueryString ="UPDATE FROM OrderPlace set orderStatusId = "+(7)+" WHERE orderId = " + orderId;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hqlQueryString);
		query.executeUpdate();
		
	}
	
	public Long orderDates() {
	
		long millis=System.currentTimeMillis();   
	    java.sql.Date date = new java.sql.Date(millis);       
	   
	    String sqlString="SELECT count(orderId) FROM OrderPlace where orderDate= '"+date+"'";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sqlString);
		Iterator count = query.iterate();
		//System.out.println("No. of rows : "+count.next()); 
		Long i = (Long) count.next();
		System.out.println(i);
		return i;
	}
	
	
	public Long orderPending() {
		
		      
	   
	    String sqlString="SELECT count(orderId) FROM OrderPlace where orderStatusId= 1";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sqlString);
		Iterator count = query.iterate();
		//System.out.println("No. of rows : "+count.next()); 
		Long i = (Long) count.next();
		System.out.println(i);
		return i;
	}
	
	public Long orderComplete() {
		
	      
		   
	    String sqlString="SELECT count(orderId) FROM OrderPlace where orderStatusId= 6";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sqlString);
		Iterator count = query.iterate();
		//System.out.println("No. of rows : "+count.next()); 
		Long i = (Long) count.next();
		System.out.println(i);
		return i;
	}

}
