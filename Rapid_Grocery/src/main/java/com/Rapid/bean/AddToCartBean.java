package com.Rapid.bean;

public class AddToCartBean {
	
private Integer cartId;
	private Integer subproductId;//fk
	private Integer userMasterId;//fk
	private Integer quantity;
	private Integer amount;	private Integer totalAmount;

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getSubproductId() {
		return subproductId;
	}

	public void setSubproductId(Integer subproductId) {
		this.subproductId = subproductId;
	}

	public Integer getUserMasterId() {
		return userMasterId;
	}

	public void setUserMasterId(Integer userMasterId) {
		this.userMasterId = userMasterId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
}
