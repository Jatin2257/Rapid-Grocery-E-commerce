package com.Rapid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Rapid.bean.OrderPlaceBean;
import com.Rapid.model.OrderPlace;

@Service
public interface OrderService {

	public void addOrder(OrderPlaceBean orderplace);
	
	public List<OrderPlace> listOrder();
	
//	public void deleteUser(Integer userMasterId);
//
	public OrderPlace getOrder(Integer orderId);
//	
	public void updateOrderStatus(Integer orderId);
	
	public void cancelOrderStatus(Integer orderId);
	public Long orderDates();
	public Long orderPending();
	public Long orderComplete();
}
