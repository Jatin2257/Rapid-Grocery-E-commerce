package com.rapid.dao;

import java.util.List;

import com.rapid.bean.OrderPlaceBean;
import com.rapid.model.OrderPlace;

public interface OrderPlaceDao {
	
//	public void addOrder(OrderPlaceBean orderplace);
	
	public List<OrderPlace> listOrder();
////	
//	public void deleteUser(Integer userMasterId);
//
	public OrderPlace getOrder(Integer userMasterId);
//	
//	public void updateOrderStatus(Integer orderId);
//	public void cancelOrderStatus(Integer orderId);
//	
//	public Long orderDates();
//	public Long orderPending();
//	public Long orderComplete();
}
