package com.rapid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_status")
public class OrderStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_status_id")
	private Integer OrderStatusId;
	
	@Column(name = "order_status_name")
	private String OrderStatusName;

	public Integer getOrderStatusId() {
		return OrderStatusId;
	}

	public void setOrderStatusId(Integer orderStatusId) {
		OrderStatusId = orderStatusId;
	}

	public String getOrderStatusName() {
		return OrderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		OrderStatusName = orderStatusName;
	}
}
