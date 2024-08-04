package com.Rapid.bean;

import java.util.Date;

public class OrderPlaceBean {

	private Integer orderId;
	private Integer userMasterId;
	private String userMasterFirstName;
	private String userMasterLastName;
	
	private Integer cartId;//fk
	private Integer totalAmount;
	private String billingAddress;
	private String shippingAddress;
	private Integer orderStatusId;
	private String orderStatusName;
	private Date orderDate;

	

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public Integer getUserMasterId() {
		return userMasterId;
	}

	public void setUserMasterId(Integer userMasterId) {
		this.userMasterId = userMasterId;
	}

	public String getUserMasterFirstName() {
		return userMasterFirstName;
	}

	public void setUserMasterFirstName(String userMasterFirstName) {
		this.userMasterFirstName = userMasterFirstName;
	}

	public String getUserMasterLastName() {
		return userMasterLastName;
	}

	public void setUserMasterLastName(String userMasterLastName) {
		this.userMasterLastName = userMasterLastName;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	
}
