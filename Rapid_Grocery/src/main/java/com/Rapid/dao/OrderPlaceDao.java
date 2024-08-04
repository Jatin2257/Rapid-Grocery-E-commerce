package com.Rapid.dao;

import java.util.List;

import com.Rapid.bean.OrderPlaceBean;
import com.Rapid.model.OrderPlace;

public interface OrderPlaceDao {
	
	public void addOrder(OrderPlaceBean orderplace);
	
	public List<OrderPlace> listOrder();
////	
//	public void deleteUser(Integer userMasterId);
//
	public OrderPlace getOrder(Integer userMasterId);
//	
	public void updateOrderStatus(Integer orderId);
	public void cancelOrderStatus(Integer orderId);
	
	public Long orderDates();
	public Long orderPending();
	public Long orderComplete();
}
