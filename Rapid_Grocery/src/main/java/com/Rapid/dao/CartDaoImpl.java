package com.Rapid.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Rapid.model.Cart;
import com.Rapid.model.SubproductMaster;
import com.Rapid.bean.CartBean;
import com.Rapid.bean.CartSubproductBean;

@Repository("cartDao")
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Autowired
	GeneralImp generalImp;
	
	@Override
	public void addToCartProducts(CartBean cartBean) {		
		
		//getPrice of subproduct
		Integer id =(Integer) cartBean.getSubproductId();
//		String hqlQuery = "from SubproductMaster where subproductId=" + id;	
		SubproductMaster subproductMaster = (SubproductMaster) generalImp.getById(SubproductMaster.class, id, sessionFactory);

		System.out.println("Product Price : "+subproductMaster.getSubproductPrice());
		Integer price = subproductMaster.getSubproductPrice();
		Cart cart = covertFomBeanToModel(cartBean,price);		
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
	 }
	
	private Cart covertFomBeanToModel(CartBean cartBean,Integer price) {
		Cart cart = new Cart();
		cart.setCartId(cartBean.getCartId());
		cart.setAmount(price);
		cart.setSubproductId(cartBean.getSubproductId());
		cart.setTotalAmount(cartBean.getQuantity()*price);
		cart.setUserMasterId(2);
		cart.setQuantity(cartBean.getQuantity());
		return cart;
	}

	@Override
	public List<CartSubproductBean> listCartItems() {
		String hqlQueryString = "SELECT c1.cartId, c1.subproductId, c1.userMasterId, c1.quantity, c1.totalAmount, "
				+ "sm.subproductId, sm.subproductName, sm.subproductPrice, sm.subproductQuantity, sm.subproductImage"
				+ " FROM SubproductMaster sm INNER JOIN Cart c1 ON c1.subproductId = sm.subproductId";	
		@SuppressWarnings("unchecked")
		List<CartSubproductBean> list = generalImp.getListByHQL(hqlQueryString, sessionFactory);		
		return list;
	}

	@Override
	public void deleteCartItem(Integer cartId) {
		String hqlQuery = "DELETE FROM Cart WHERE cartId = " + cartId;
		generalImp.deleteByHQL(hqlQuery, sessionFactory);
	}

	@Override
	public void updateQuantity(Integer cartId, Integer quantity) {
//		String hqlQuery1 = "UPDATE Cart SET quantity=1 WHERE cartId="+cartId;
		Cart cart = (Cart)generalImp.getById(Cart.class, cartId, sessionFactory);
		cart.setQuantity(quantity);
//		cart.setTotalAmount(cart.getAmount()*quantity);
		cart.setTotalAmount(0);
		generalImp.modify(cart, sessionFactory);
	}
}
