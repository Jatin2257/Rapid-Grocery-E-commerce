package com.rapid.service;

import java.util.List;

import com.rapid.bean.CartBean;
import com.rapid.bean.CartSubproductBean;
import com.rapid.model.Cart;

public interface CartService {

	public void addToCartProducts(CartBean cartBean);

	public List<CartSubproductBean> listCartItems();

	public void deleteCartItem(Integer cartId);

	public void updateQuantity(Integer cartId, Integer quantity);

	public void addToCartSingleProduct(CartBean cartBean);
}
