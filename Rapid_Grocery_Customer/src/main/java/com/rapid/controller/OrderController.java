package com.rapid.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rapid.bean.LoggerInfo;
import com.rapid.bean.OrderPlaceBean;
import com.rapid.model.OrderPlace;
import com.rapid.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/order_list", method = RequestMethod.GET)
	public ModelAndView viewAllOrder() {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<OrderPlace> list = orderService.listOrder();
		System.out.println(list);
		model.put("myorders", prepareListofBean2(list));
		return new ModelAndView("myorderlist", model);}
		return new ModelAndView("redirect:/login");
	}


	private List<OrderPlaceBean> prepareListofBean2(List<OrderPlace> cat) {
		List<OrderPlaceBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<OrderPlaceBean>();
			OrderPlaceBean bean = null;
			Iterator itr = cat.iterator();
			while (itr.hasNext()) {
				bean = new OrderPlaceBean();
				Object[] obj = (Object[]) itr.next();

				bean.setOrderId(Integer.parseInt(String.valueOf(obj[0])));
				bean.setCartId(Integer.parseInt(String.valueOf(obj[1])));
				bean.setOrderStatusId(Integer.parseInt(String.valueOf(obj[2])));
				bean.setUserMasterId(Integer.parseInt(String.valueOf(obj[3])));
				bean.setBillingAddress(String.valueOf(obj[4]));
				bean.setShippingAddress(String.valueOf(obj[5]));
				bean.setTotalAmount(Integer.parseInt(String.valueOf(obj[6])));
				bean.setOrderStatusName(String.valueOf(obj[8]));
				bean.setUserMasterFirstName(String.valueOf(obj[10]));
				bean.setUserMasterLastName(String.valueOf(obj[11]));
				 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			     
			      Date date=null;
				try {
					date = formatter.parse(String.valueOf(obj[12]));
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			      
				
				bean.setOrderDate(date);

				beans.add(bean);
			}

		}
		return beans;
	}


}
