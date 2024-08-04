package com.rapid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.rapid.bean.OrderPlaceBean;
import com.rapid.bean.SubproductMasterBean;
import com.rapid.bean.UserMasterBean;

import com.rapid.dao.OrderPlaceDao;
import com.rapid.dao.SubProductDao;
import com.rapid.dao.UserDao;

import com.rapid.model.OrderPlace;
import com.rapid.model.SubproductMaster;
import com.rapid.model.UserMaster;

@Service("orderService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderPlaceDao orderplaceDao;

	//add Category
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//	public void addOrder(OrderPlaceBean orderplace) {
//		orderplaceDao.addOrder(orderplace);
//	}

	@Override
	public List<OrderPlace> listOrder() {
		return orderplaceDao.listOrder();
	}

	

//	@Override
//	@Transactional
//	public void deleteUser(Integer userMasterId) {
//		userDao.deleteUser(userMasterId);
//	}
////
	@Override
	public OrderPlace getOrder(Integer userMasterId) {
		return orderplaceDao.getOrder(userMasterId);
	}
//
//	@Override
//	@Transactional
//	public void updateOrderStatus(Integer orderId) {
//		orderplaceDao.updateOrderStatus(orderId);
//	}
//	
//	@Override
//	@Transactional
//	public void cancelOrderStatus(Integer orderId) {
//		orderplaceDao.cancelOrderStatus(orderId);
//	}
//
//	
//	@Override
//	@Transactional
//	public Long orderDates() {
//		return orderplaceDao.orderDates();
//	}
//	
//	@Override
//	@Transactional
//	public Long orderPending() {
//		return orderplaceDao.orderPending();
//	}
//	
//	@Override
//	@Transactional
//	public Long orderComplete() {
//		return orderplaceDao.orderComplete();
//	}
	
	
		
}

