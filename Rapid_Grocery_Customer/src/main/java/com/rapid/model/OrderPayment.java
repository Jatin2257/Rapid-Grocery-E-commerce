package com.rapid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_payment")
public class OrderPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_payment_id")
	public Integer orderPaymentId;
	
	@Column(name = "order_id")
	public Integer OrderId;
	
	@Column(name = "payment_mode_id")
	public Integer paymentModeId;//fk
	
	@Column(name = "payment_date")
	public Date paymentDate;//date

	public Integer getOrderPaymentId() {
		return orderPaymentId;
	}

	public void setOrderPaymentId(Integer orderPaymentId) {
		this.orderPaymentId = orderPaymentId;
	}

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public Integer getPaymentModeId() {
		return paymentModeId;
	}

	public void setPaymentModeId(Integer paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
}
