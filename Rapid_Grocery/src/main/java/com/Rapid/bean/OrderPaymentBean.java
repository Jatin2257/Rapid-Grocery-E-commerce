package com.Rapid.bean;

import java.util.Date;

public class OrderPaymentBean {

private Integer orderPaymentId;
	
	private Integer OrderId;
	private Integer paymentModeId;//fk
	private Date paymentDate;//date

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
