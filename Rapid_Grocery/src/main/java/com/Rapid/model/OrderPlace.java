package com.Rapid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "order_place")
public class OrderPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "cart_id")
	private Integer cartId;

	@Column(name = "total_amount")
	private Integer totalAmount;

	@Column(name = "billing_address")
	private String billingAddress;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@Column(name = "order_status_id")
	private Integer orderStatusId;

	@Column(name = "user_master_id")
	private Integer userMasterId;

	@Transient
	@Column(name = "user_first_name")
	private String userMasterFirstName;

	@Transient
	@Column(name = "user_last_name")
	private String userMasterLastName;

	@Transient
	@Column(name = "order_status_name")
	private String orderStatusName;
	
	@Column(name = "order_date")
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

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
