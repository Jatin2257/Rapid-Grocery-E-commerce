package com.Rapid.service;

import java.util.List;

import com.Rapid.bean.CartBean;
import com.Rapid.bean.CartSubproductBean;
import com.Rapid.model.Cart;

public interface CartService {

	public void addToCartProducts(CartBean cartBean);

	public List<CartSubproductBean> listCartItems();

	public void deleteCartItem(Integer cartId);

	public void updateQuantity(Integer cartId, Integer quantity);
}
