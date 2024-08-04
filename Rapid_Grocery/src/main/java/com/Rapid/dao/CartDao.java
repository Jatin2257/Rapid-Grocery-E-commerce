package com.Rapid.dao;

import java.util.List;

import com.Rapid.bean.CartBean;
import com.Rapid.bean.CartSubproductBean;


public interface CartDao {

	public void addToCartProducts(CartBean cartBean);

	public List<CartSubproductBean> listCartItems();

	public void deleteCartItem(Integer cartId);

	public void updateQuantity(Integer cartId, Integer quantity);

}
