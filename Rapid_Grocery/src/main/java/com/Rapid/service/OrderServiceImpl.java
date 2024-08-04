package com.Rapid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.OrderPlaceBean;
import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.bean.UserMasterBean;
import com.Rapid.dao.CategoryDao;
import com.Rapid.dao.CategoryDaoImpl;
import com.Rapid.dao.OrderPlaceDao;
import com.Rapid.dao.SubProductDao;
import com.Rapid.dao.UserDao;
import com.Rapid.model.Category;
import com.Rapid.model.OrderPlace;
import com.Rapid.model.SubproductMaster;
import com.Rapid.model.UserMaster;

@Service("orderService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderPlaceDao orderplaceDao;

	//add Category
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addOrder(OrderPlaceBean orderplace) {
		orderplaceDao.addOrder(orderplace);
	}

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
	@Override
	@Transactional
	public void updateOrderStatus(Integer orderId) {
		orderplaceDao.updateOrderStatus(orderId);
	}
	
	@Override
	@Transactional
	public void cancelOrderStatus(Integer orderId) {
		orderplaceDao.cancelOrderStatus(orderId);
	}

	
	@Override
	@Transactional
	public Long orderDates() {
		return orderplaceDao.orderDates();
	}
	
	@Override
	@Transactional
	public Long orderPending() {
		return orderplaceDao.orderPending();
	}
	
	@Override
	@Transactional
	public Long orderComplete() {
		return orderplaceDao.orderComplete();
	}
	
	
		
}
