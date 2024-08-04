package com.Rapid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "add_to_cart")
public class AddToCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Integer cartId;
	
	@Column(name = "subproduct_id")
	private Integer subproductId;//fk
	
	@Column(name = "user_master_id")
	private Integer userMasterId;//fk
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "amount")
	private Integer amount;
	
	@Column(name = "total_amount")
	private Integer totalAmount;

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
