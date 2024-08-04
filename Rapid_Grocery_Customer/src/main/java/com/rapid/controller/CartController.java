package com.rapid.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.tribes.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rapid.bean.CartBean;
import com.rapid.bean.SubproductMasterBean;
import com.rapid.bean.CartSubproductBean;
import com.rapid.model.Cart;
import com.rapid.model.SubproductMaster;
import com.rapid.service.CartService;
import com.rapid.service.SubProductService;

@Controller
public class CartController {

	@Autowired
	public CartService cartService;
	
	@Autowired
	public SubProductService subProductService;

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public ModelAndView AddToCart(@ModelAttribute("Cart") CartBean cartBean, BindingResult result) {
		cartService.addToCartProducts(cartBean);
		List<CartSubproductBean> list = cartService.listCartItems();
		System.out.println(list.toString());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cartsubproducts", prepareListofBean2(list));
		return new ModelAndView("redirect:/cart", model);
	}	

	// for display product
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView ViewCartItems() {		
		List<CartSubproductBean> list = cartService.listCartItems();
		if(null == list) {
			return new ModelAndView("redirect:/login");
		} else {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("cartsubproducts", prepareListofBean2(list));	
			model.put("Cart", new Cart());
			return new ModelAndView("cart", model);
		}
	}
	
	//Remove Cart Item
	@RequestMapping(value = "/removeCartItem", method = RequestMethod.GET)
	public ModelAndView RemoveCartItem(@ModelAttribute("Cart") CartBean cartBean, BindingResult result) {
		cartService.deleteCartItem(cartBean.getCartId());
		List<CartSubproductBean> list = cartService.listCartItems();
		Map<String, Object> model = new HashMap<String, Object>();
		//model.put("Cart", null);
		model.put("cartsubproducts", prepareListofBean2(list));	
		return new ModelAndView("redirect:/cart");
	}
	
	//Add Particular Products
	@RequestMapping(value = "/addToCartFromProducts", method = RequestMethod.GET)
	public ModelAndView addToCartParticularProduct(@ModelAttribute("Cart") CartBean cartBean, BindingResult result) {
		cartService.addToCartSingleProduct(cartBean);
		List<CartSubproductBean> list = cartService.listCartItems();
		System.out.println(list);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cartsubproducts", prepareListofBean2(list));
		return new ModelAndView("redirect:/cart", model);
	}

	@RequestMapping(value = "/updateQuantityPlus", method = RequestMethod.GET)
	public ModelAndView UpdateQuantityPlus(@ModelAttribute("Cart") CartBean cartBean, BindingResult result,Model model1,HttpServletRequest request) {

		cartService.updateQuantity(cartBean.getCartId(), 1);		
		List<CartSubproductBean> list = cartService.listCartItems();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cartsubproducts", prepareListofBean2(list));	
		return new ModelAndView("redirect:/cart");
	}
	
	@RequestMapping(value = "/updateQuantityMinus", method = RequestMethod.GET)
	public ModelAndView UpdateQuantityMinus(@ModelAttribute("Cart") CartBean cartBean, BindingResult result) {
		cartService.updateQuantity(cartBean.getCartId(), 0);				
		List<CartSubproductBean> list = cartService.listCartItems();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cartsubproducts", prepareListofBean2(list));	
		return new ModelAndView("redirect:/cart");
	}

	private List<CartSubproductBean> prepareListofBean2(List<CartSubproductBean> cat) {
		List<CartSubproductBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<CartSubproductBean>();
			CartSubproductBean bean = null;
			Iterator itr = cat.iterator();
			while (itr.hasNext()) {
				bean = new CartSubproductBean();
				Object[] obj = (Object[]) itr.next();
				int i = 0;

				bean.setCartId(Integer.parseInt(String.valueOf(obj[0])));
				bean.setSubproductId(Integer.parseInt(String.valueOf(obj[1])));
				bean.setQuantity(Integer.parseInt(String.valueOf(obj[3])));
				bean.setTotalAmount(Integer.parseInt(String.valueOf(obj[4])));
				bean.setSubproductName(String.valueOf(obj[6]));
				bean.setSubproductPrice(Integer.parseInt(String.valueOf(obj[7])));
				bean.setSubproductQuantity(Integer.parseInt(String.valueOf(obj[8])));				
				bean.setSubproductImage(String.valueOf(obj[9]));					

				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<CartSubproductBean> prepareListofBean3(List<CartSubproductBean> cart){
		List<CartSubproductBean> beans = null;
		if(cart != null && !cart.isEmpty()){
			beans = new ArrayList<CartSubproductBean>();
			CartSubproductBean bean = null;
			//CartSubproductBean bean2 = null;
			for(CartSubproductBean cart1 : cart){
				bean = new CartSubproductBean();
				bean.setCartId(cart1.getCartId());		
				bean.setSubproductId(cart1.getSubproductId());
				bean.setQuantity(cart1.getQuantity());
				bean.setTotalAmount(cart1.getTotalAmount());
				bean.setUserMasterId(cart1.getUserMasterId());
//				bean.setSubproductImage(cart1.getSubproductImage());
//				bean2.setSubproductId(cart1.getSubproductId());
//				bean2.setSubproductName(cart1.getSubproductName());
//				bean2.setSubproductPrice(cart1.getSubproductPrice());
//				bean2.setSubproductImage(cart1.getSubproductImage());
//				bean2.setSubproductQuantity(cart1.getSubproductQuantity());
//				beans.add(bean2);
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<SubproductMasterBean> prepareListofBean1(List<SubproductMaster> sub) {
		List<SubproductMasterBean> beans = null;
		if (sub != null && !sub.isEmpty()) {
			beans = new ArrayList<SubproductMasterBean>();
			SubproductMasterBean bean = null;
			for (SubproductMaster subproductMaster : sub) {
				bean = new SubproductMasterBean();
				bean.setSubproductId(subproductMaster.getSubproductId());
				bean.setSubproductName(subproductMaster.getSubproductName());
				bean.setSubproductPrice(subproductMaster.getSubproductPrice());
				bean.setSubproductImage(subproductMaster.getSubproductImage());
				bean.setSubproductQuantity(subproductMaster.getSubproductQuantity());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private List<CartBean> prepareListofBean(List<Cart> cart){
		List<CartBean> beans = null;
		if(cart != null && !cart.isEmpty()){
			beans = new ArrayList<CartBean>();
			CartBean bean = null;
			for(Cart cart1 : cart){
				bean = new CartBean();
				bean.setCartId(cart1.getCartId());		
				bean.setSubproductId(cart1.getSubproductId());
				bean.setQuantity(cart1.getQuantity());
				bean.setTotalAmount(cart1.getTotalAmount());				
				beans.add(bean);
			}
		}
		return beans;
	}
	
}