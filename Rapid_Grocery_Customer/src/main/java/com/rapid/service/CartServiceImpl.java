package com.rapid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rapid.bean.CartBean;
import com.rapid.bean.CartSubproductBean;
import com.rapid.dao.CartDao;
import com.rapid.model.Cart;

@Service("cartService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CartServiceImpl implements CartService{

	@Autowired
	public CartDao cartDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addToCartProducts(CartBean cartBean) {
		cartDao.addToCartProducts(cartBean);
	}

	@Override
	public List<CartSubproductBean> listCartItems() {
		return cartDao.listCartItems();
	}

	@Override
	@Transactional
	public void deleteCartItem(Integer cartId) {
		cartDao.deleteCartItem(cartId);
	}
	
	@Override
	@Transactional
	public void updateQuantity(Integer cartId, Integer quantity) {
		cartDao.updateQuantity(cartId, quantity);
	}

	@Override
	@Transactional
	public void addToCartSingleProduct(CartBean cartBean) {
		cartDao.addToCartSingleProduct(cartBean);
	}

}
