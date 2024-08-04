package com.Rapid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.LoggerInfo;
import com.Rapid.bean.ProductMasterBean;
import com.Rapid.bean.SubproductMasterBean;

import com.Rapid.model.Category;
import com.Rapid.model.FeedbackTable;
import com.Rapid.model.OrderPlace;
import com.Rapid.model.ProductMaster;
import com.Rapid.model.SubproductMaster;
import com.Rapid.model.UserMaster;
import com.Rapid.service.CategoryService;
import com.Rapid.service.FeedbackService;
import com.Rapid.service.OrderService;
import com.Rapid.service.SubProductService;
import com.Rapid.service.UserService;
import com.Rapid.service.ProductService;

@Controller
public class MainController {

	@Autowired
	private HttpSession session;

	@Autowired
	private SubProductService subProductService;
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private FeedbackService feedbackService;
	
//	updated start
	@RequestMapping("/eCommerce")
	public ModelAndView viewHome1() {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			Map<String, Object> model1 = new HashMap<String, Object>();
			List<Category> list1 = categoryService.listCategory();
			model1.put("categorys", prepareListofBean3(list1));
			List<SubproductMaster> list = subProductService.listSubProduct();
			model1.put("subproducts", prepareListofBean2(list));
			Long count = userService.countofUsers();
			Long countemp = userService.countofEmp();
			Long countorder = orderService.orderDates();
			Long countorderpending = orderService.orderPending();
			Long countordercomplete = orderService.orderComplete();
			Long countsubproducts = subProductService.subproductcount();
			Long countproducts = productService.productcount();
			Long countfeedbacks = feedbackService.feedbackcount();
			model1.put("usercounts", count);
			model1.put("empcounts", countemp);
			model1.put("ordercounts", countorder);
			model1.put("orderpendcounts", countorderpending);
			model1.put("ordercomcounts", countordercomplete);
			model1.put("subproductscounts", countsubproducts);
			model1.put("productscounts", countproducts);
			model1.put("feedbackcounts", countfeedbacks);
			return new ModelAndView("home", model1);
		}
		return new ModelAndView("redirect:/signin");
	}
	
	
	
//	updated end
	

	@RequestMapping("/")
	public ModelAndView viewHome() {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			Map<String, Object> model1 = new HashMap<String, Object>();
			List<Category> list1 = categoryService.listCategory();
			model1.put("categorys", prepareListofBean3(list1));
			List<SubproductMaster> list = subProductService.listSubProduct();
			model1.put("subproducts", prepareListofBean2(list));
			Long count = userService.countofUsers();
			Long countemp = userService.countofEmp();
			Long countorder = orderService.orderDates();
			Long countorderpending = orderService.orderPending();
			Long countordercomplete = orderService.orderComplete();
			Long countsubproducts = subProductService.subproductcount();
			Long countproducts = productService.productcount();
			Long countfeedbacks = feedbackService.feedbackcount();
			model1.put("usercounts", count);
			model1.put("empcounts", countemp);
			model1.put("ordercounts", countorder);
			model1.put("orderpendcounts", countorderpending);
			model1.put("ordercomcounts", countordercomplete);
			model1.put("subproductscounts", countsubproducts);
			model1.put("productscounts", countproducts);
			model1.put("feedbackcounts", countfeedbacks);
			return new ModelAndView("home", model1);
		}
		return new ModelAndView("redirect:/signin");
	}

	@RequestMapping("/viewproducts")
	public String viewProducts() {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			return "viewproducts";
		}
		return "signin";
	}

	// For category Page
	@RequestMapping("/category")
	public String category(Model model) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			model.addAttribute("Category", new Category());
			return "category";
		}
		return "signin";
	}

	@RequestMapping("/category_list")
	public String category_list(Model model) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			model.addAttribute("Category", new Category());
			return "category_list";
		}
		return "signin";
	}

//	@RequestMapping("/subproduct")
//	public String subProduct(Model model)
//	{
//		model.addAttribute("SubProduct", new SubproductMaster());
//		return "subproduct2";
//	}

	@RequestMapping("/product")
	public ModelAndView Product(Model model, ProductMasterBean product, BindingResult result) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {

			Map<String, Object> model1 = new HashMap<String, Object>();
			List<Category> list1 = categoryService.listCategory();
			model1.put("categorys", prepareListofBeanProduct(list1));

			model.addAttribute("Product", new ProductMaster());
			return new ModelAndView("product", model1);
		}
		return new ModelAndView("redirect:/signin");
	}

	@RequestMapping("/product_list")
	public String product_list(Model model) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			model.addAttribute("Product", new ProductMaster());
			return "product_list";
		}
		return "signin";
	}

	@RequestMapping("/subproduct")
	public ModelAndView subProduct(Model model, SubproductMasterBean subproduct, BindingResult result) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			Map<String, Object> model1 = new HashMap<String, Object>();
			List<ProductMaster> list1 = productService.listProduct1();
			model1.put("products", prepareListofBean1(list1));
			System.out.println(model1);
			model.addAttribute("SubProduct", new SubproductMaster());

			return new ModelAndView("subproduct2", model1);
		}
		return new ModelAndView("redirect:/signin");
	}

	@RequestMapping("/subproduct_list")
	public String subProduct_list(Model model) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			model.addAttribute("SubProduct", new SubproductMaster());
			return "subproduct_list";
		}
		return "signin";

	}

	@RequestMapping("/user")
	public String userMaster(Model model) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			model.addAttribute("User", new UserMaster());
			return "userinsert";
		}
		return "signin";
	}

	@RequestMapping("/user_list")
	public String user_list(Model model) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			model.addAttribute("User", new UserMaster());
			return "user_list";
		}
		return "signin";
	}

	@RequestMapping("/signin")
	public String signin(Model model) {
		model.addAttribute("User", new UserMaster());
		return "signin";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			model.addAttribute("User", new UserMaster());	
			return "profile";
		}
		return "signin";
	}
	
	

	@RequestMapping("/order_list")
	public String order_list(Model model) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			model.addAttribute("Order", new OrderPlace());
			return "order_list";
		}
		return "signin";
	}

	@RequestMapping("/feedback_list")
	public String feedback_list(Model model) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			model.addAttribute("Feedback", new FeedbackTable());
			return "feedback_list";
		}
		return "signin";
	}
	@RequestMapping("/employee")
	public String employee(Model model)
	{
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
		model.addAttribute("Employee", new UserMaster());
		return "employee";}
		return "signin";
	}
	
	@RequestMapping("/employee_list")
	public String employee_list()
	{
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			return "employee_list";}
		return "signin";
	}
	
	
	

	private List<CategoryBean> prepareListofBeanProduct(List<Category> cat) {
		List<CategoryBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<CategoryBean>();
			CategoryBean bean = null;
			for (Category product : cat) {
				bean = new CategoryBean();
				System.out.println(product.getCategoryId());
				bean.setCategoryId(product.getCategoryId());
				bean.setCategoryName(product.getCategoryName());
				beans.add(bean);
			}
		}
		return beans;
	}

	private List<ProductMasterBean> prepareListofBean1(List<ProductMaster> cat) {
		List<ProductMasterBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<ProductMasterBean>();
			ProductMasterBean bean = null;
			for (ProductMaster product : cat) {
				bean = new ProductMasterBean();
				System.out.println(product.getProductId());
				bean.setProductId(product.getProductId());
				bean.setProductName(product.getProductName());
				beans.add(bean);
			}
		}
		return beans;
	}

	private List<SubproductMasterBean> prepareListofBean2(List<SubproductMaster> cat) {
		List<SubproductMasterBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<SubproductMasterBean>();
			SubproductMasterBean bean = null;
			Iterator itr = cat.iterator();
			while (itr.hasNext()) {
				bean = new SubproductMasterBean();
				Object[] obj = (Object[]) itr.next();
				int i = 0;

				bean.setSubproductId(Integer.parseInt(String.valueOf(obj[0])));
				bean.setSubproductName(String.valueOf(obj[1]));
				bean.setSubproductPrice(Integer.parseInt(String.valueOf(obj[2])));
				bean.setSubproductQuantity(Integer.parseInt(String.valueOf(obj[3])));
				bean.setSubproductDescription(String.valueOf(obj[4]));

				bean.setProductId(Integer.parseInt(String.valueOf(obj[5])));
				bean.setProductName(String.valueOf(obj[7]));

				beans.add(bean);
			}
		}
		return beans;
	}

	private List<CategoryBean> prepareListofBean3(List<Category> cat) {
		List<CategoryBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<CategoryBean>();
			CategoryBean bean = null;
			for (Category category : cat) {
				bean = new CategoryBean();
				bean.setCategoryId(category.getCategoryId());
				bean.setCategoryName(category.getCategoryName());
				beans.add(bean);
			}
		}
		return beans;
	}

	/*
	 * @RequestMapping("/deleteCategory") public String deletecategory(Model model)
	 * { model.addAttribute("Category", new Category()); return "category_list"; }
	 */

}
