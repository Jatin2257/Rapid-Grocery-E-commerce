package com.rapid.dao;


import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapid.model.Cart;
import com.rapid.model.SubproductMaster;
import com.rapid.bean.CartBean;
import com.rapid.bean.CartSubproductBean;
import com.rapid.bean.LoggerInfo;

@Repository("cartDao")
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	GeneralImp generalImp;
	
	@Autowired
	HttpSession session;
	
	@Override
	public void addToCartProducts(CartBean cartBean) {		
		
		//getPrice of subproduct
		Integer id =(Integer) cartBean.getSubproductId();
		//String hqlQuery = "from SubproductMaster where subproductId=" + id;	
		SubproductMaster subproductMaster = (SubproductMaster) generalImp.getById(SubproductMaster.class, id, sessionFactory);
		
//		if item is already exists
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");				
		String hqlQuery_cart = "SELECT subproductId, userMasterId FROM Cart WHERE subproductId="+id+
				" AND userMasterId="+loggerInfo.getUserId(); 
		
		List<Cart> cart1 = (List<Cart>) generalImp.getListByHQL(hqlQuery_cart, sessionFactory);
		
		System.out.println("Product Price : "+subproductMaster.getSubproductPrice());
		Integer price = subproductMaster.getSubproductPrice();

		if (cart1 == null || cart1.isEmpty()) {		
			Cart cart = covertFomBeanToModel(cartBean,price,"DetailsPage");					
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
		}else {
			System.out.println("already exists");
		}
	
	 }

	@Override
	public List<CartSubproductBean> listCartItems() {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
			String hqlQueryString = "SELECT c1.cartId, c1.subproductId, c1.userMasterId, c1.quantity, c1.totalAmount, "
					+ "sm.subproductId, sm.subproductName, sm.subproductPrice, sm.subproductQuantity, sm.subproductImage"
					+ " FROM SubproductMaster sm INNER JOIN Cart c1 ON c1.subproductId = sm.subproductId WHERE c1.userMasterId="+loggerInfo.getUserId();	
			@SuppressWarnings("unchecked")
			List<CartSubproductBean> list = generalImp.getListByHQL(hqlQueryString, sessionFactory);		
			return list;
		} else {
			return null;
		}
	}

	@Override
	public void deleteCartItem(Integer cartId) {
		String hqlQuery = "DELETE FROM Cart WHERE cartId = " + cartId;
		generalImp.deleteByHQL(hqlQuery, sessionFactory);
	}

	@Override
	public void updateQuantity(Integer cartId, Integer quantity) {

		String hqlQueryString = "SELECT c1.cartId, c1.subproductId, c1.userMasterId, sm.subproductId, sm.subproductQuantity"
				+ " FROM SubproductMaster sm INNER JOIN Cart c1 ON c1.subproductId = sm.subproductId WHERE c1.cartId="+cartId;
		List<SubproductMaster> list = (List<SubproductMaster>) generalImp.getListByHQL(hqlQueryString, sessionFactory);
		
		Integer qtySubproduct = 0;
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			qtySubproduct = Integer.parseInt(String.valueOf(obj[4]));
		}
		
		Cart cart = (Cart)generalImp.getById(Cart.class, cartId, sessionFactory);
		if(quantity == 1) {
//			if(cart.getQuantity()<qtySubproduct) {				
				cart.setQuantity(cart.getQuantity()+1);
//			}
		}
		else {
			if(cart.getQuantity()>1) {
				cart.setQuantity(cart.getQuantity()-1);			
			}
		}
		
		cart.setTotalAmount(cart.getAmount()*cart.getQuantity());	
		generalImp.modify(cart, sessionFactory);
	}

	@Override
	public void addToCartSingleProduct(CartBean cartBean) {
		Integer id =(Integer) cartBean.getSubproductId();
		String hqlQuery = "from SubproductMaster where subproductId=" + id;	
		SubproductMaster subproductMaster = (SubproductMaster) generalImp.getById(SubproductMaster.class, id, sessionFactory);
		
//		if item is already exists
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");				
		String hqlQuery_cart = "SELECT subproductId, userMasterId FROM Cart WHERE subproductId="+id+" AND userMasterId="+loggerInfo.getUserId(); 
		
		List<Cart> cart1 = (List<Cart>) generalImp.getListByHQL(hqlQuery_cart, sessionFactory);
		Integer price = subproductMaster.getSubproductPrice();

		if (cart1 == null || cart1.isEmpty()) {		
			Cart cart = covertFomBeanToModel(cartBean,price,"HomePage");		
			sessionFactory.getCurrentSession().saveOrUpdate(cart);		
		}else {
			System.out.println("already exists");
		}
	}
	
	private Cart covertFomBeanToModel(CartBean cartBean, Integer price, String value) {		
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		
		Cart cart = new Cart();
		
		cart.setSubproductId(cartBean.getSubproductId());
		cart.setCartId(cartBean.getCartId());
		cart.setAmount(price);
		if (value=="DetailsPage") {
			cart.setQuantity(cartBean.getQuantity());
			cart.setTotalAmount(cartBean.getQuantity()*price);			
		}
		else {
			cart.setQuantity(1);
			cart.setTotalAmount(price);
		}
		
		cart.setUserMasterId(loggerInfo.getUserId());
		return cart;
	}
}
