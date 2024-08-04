package com.Rapid.controller;

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

import com.Rapid.bean.LoggerInfo;
import com.Rapid.bean.OrderPlaceBean;
import com.Rapid.model.OrderPlace;
import com.Rapid.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private HttpSession session;

//	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
//	public ModelAndView insertCategory(@ModelAttribute("User") UserMasterBean userMaster,
//			BindingResult bindingResult) {
//
//		userService.addUser(userMaster);
//
//		System.out.println("............................");
//		Map<String, Object> model = new HashMap<String, Object>();
//
//		List<UserMaster> list = userService.listUser();
//
//		model.put("users", prepareListofBean(list));
//		return new ModelAndView("redirect:/user_list", model);
//	}

//	
	@RequestMapping(value = "/order_list", method = RequestMethod.GET)
	public ModelAndView viewAllOrder() {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<OrderPlace> list = orderService.listOrder();
		model.put("orders", prepareListofBean2(list));
		return new ModelAndView("order_list", model);}
		return new ModelAndView("redirect:/signin");
	}

//	//for delete
//	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
//	public ModelAndView deleteUser(@ModelAttribute("User") UserMasterBean userMaster, BindingResult result) {
//		userService.deleteUser(userMaster.getUserMasterId());
//		Map<String, Object> model = new HashMap<String, Object>();
//		List<UserMaster> list = userService.listUser();
//		
//		model.put("user", null);
//		model.put("users", prepareListofBean(list));
//		return new ModelAndView("redirect:/user_list");
//
//	}
//	
//	@RequestMapping(value = "/updateActiveUser", method = RequestMethod.GET)
//	public ModelAndView updateActiveUser(@ModelAttribute("User") UserMasterBean user, BindingResult result) {
//		userService.updateActiveUser(user.getUserMasterId());
//		/*user.setUserMasterId(userMaster.getUserMasterId());
//		if(userMaster.getIsActive()== "0") {
//		user.setIsActive("1");
//		}else {
//			user.setIsActive("0");
//		}
//		
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("user", userMaster);*/
//	
//		return new ModelAndView("redirect:/user_list");
//
//	}

//	
//	//for edit
	@RequestMapping(value = "/editOrderStatus", method = RequestMethod.GET)
	public ModelAndView editOrderStatus(Integer orderId) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		orderService.updateOrderStatus(orderId);
		return new ModelAndView("redirect:/order_list");
		}
		return new ModelAndView("redirect:/signin");
	}

	@RequestMapping(value = "/cancelOrderStatus", method = RequestMethod.GET)
	public ModelAndView CancelOrder(Integer orderId) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
	
		orderService.cancelOrderStatus(orderId);
		return new ModelAndView("redirect:/order_list");
	}
	return new ModelAndView("redirect:/signin");
	}
//
//	private List<UserMasterBean> prepareListofBean(List<UserMaster> cat) {
//		List<UserMasterBean> beans = null;
//		if (cat != null && !cat.isEmpty()) {
//			beans = new ArrayList<UserMasterBean>();
//			UserMasterBean bean = null;
//			for (UserMaster subProduct : cat) {
//				
//				bean = new UserMasterBean();
//				bean.setUserMasterId(subProduct.getUserMasterId());
//				bean.setUserMasterFirstName(subProduct.getUserMasterFirstName());
//				bean.setUserMasterLastName(subProduct.getUserMasterLastName());
//				bean.setUserEmailId(subProduct.getUserEmailId());
//				bean.setUserAddress(subProduct.getUserAddress());
//				bean.setUserContact(subProduct.getUserContact());
//				bean.setUserDOB(subProduct.getUserDOB());
//				bean.setUserPassword(subProduct.getUserPassword());
//				bean.setUserTId(subProduct.getUserTId());
//				bean.setUserSalary(subProduct.getUserSalary());
//				bean.setIsActive(subProduct.getIsActive());
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}

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
//	private Date changedate(Date userDOB) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
//
//		String datesString = "";
//		datesString = dateFormat.format(userDOB);
//		try {
//			userDOB = (Date) dateFormat.parse(datesString);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return userDOB;
//
//	}

//	private Category prepareModel(CategoryBean categoryBean) {
//		Category category = new Category();
//		category.setCategoryId(categoryBean.getCategoryId());
//		category.setCategoryName(categoryBean.getCategoryName());
//		categoryBean.setCategoryId(null);
//		return category;
//	}

//	private CategoryBean prepareCategoryBean(Category category){
//		CategoryBean bean = new CategoryBean();
//		bean.setCategoryId(category.getCategoryId());
//		bean.setCategoryName(category.getCategoryName());
//		return bean;
//	}

}
