package com.rapid.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rapid.bean.CartBean;
import com.rapid.bean.CartSubproductBean;
import com.rapid.service.CartService;
import com.rapid.service.CheckoutService;

@Controller
public class CheckoutController {

	@Autowired
	public CartService cartService;
	
	//list of sub products in checkout.jsp
	@RequestMapping(value = "/proceedToCheckout", method = RequestMethod.GET)
	public ModelAndView AddToCart(@ModelAttribute("Cart") CartBean cartBean, BindingResult result) {
		List<CartSubproductBean> list = cartService.listCartItems();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("cartsubproducts", prepareListofBean2(list));
		return new ModelAndView("/checkout", model);
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
}
