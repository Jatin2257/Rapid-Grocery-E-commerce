package com.rapid;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rapid.model.UserMaster;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rapid.bean.ProductMasterBean;
import com.rapid.bean.SubproductMasterBean;
import com.rapid.model.SubproductMaster;
import com.rapid.model.UserMaster;
import com.rapid.service.SubProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rapid.service.CategoryService;
import com.rapid.service.ProductService;
import com.google.gson.Gson;
import com.rapid.bean.CategoryBean;
import com.rapid.model.Category;
import com.rapid.model.ProductMaster;
import com.rapid.service.ProfileService;

@Controller
public class MainController {

	@Autowired
	private SubProductService subProductService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	// @RequestMapping("/")
	// public String viewHome()
	// {
	// return "home";
	// }

	@RequestMapping("/")
	public ModelAndView Category() {
		Map<String, Object> model1 = new HashMap<String, Object>();

		List<Category> list = categoryService.listCategory();
		System.out.println("Done");
		model1.put("categorys", prepareListofBeanProduct(list));

		List<SubproductMaster> list1 = subProductService.listSubProduct();
		model1.put("subproducts", prepareListofBean1(list1));
		return new ModelAndView("home", model1);

	}

	@ResponseBody
	@RequestMapping(value = "/showProducts/{id}", method = RequestMethod.GET)
	public String loadProductsByCategory(@PathVariable("id") int id) {
		Gson gson = new Gson();
		return gson.toJson(productService.getProduct(id));
	}

//	Do Your Mapping Below
	@RequestMapping("/product")
	public ModelAndView Product(Model model, ProductMasterBean product, BindingResult result) {
		Map<String, Object> model1 = new HashMap<String, Object>();
		List<Category> list1 = categoryService.listCategory();
		model1.put("categorys", prepareListofBeanProduct(list1));

		model.addAttribute("Product", new ProductMaster());
		return new ModelAndView("product", model1);
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
				System.out.println(product.getCategoryName());
				bean.setCategoryName(product.getCategoryName());
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
				byte[] encodeBase64 = Base64.encodeBase64(subproductMaster.getImagestore());
				String base64Encoded = null;
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bean.setSubproductImage(String.valueOf(base64Encoded));
				bean.setSubproductQuantity(subproductMaster.getSubproductQuantity());
				beans.add(bean);
			}
		}
		return beans;
	}

	@RequestMapping("/profile")
	public ModelAndView viewProfile(Model model) {
		Map<String, Object> model1 = new HashMap<String, Object>();

		List<Category> list = categoryService.listCategory();
		System.out.println("Done");
		model1.put("categorys", prepareListofBeanProduct(list));
		model.addAttribute("User", new UserMaster());
		return new ModelAndView("profile", model1);

	}

	@RequestMapping("/about")
	public ModelAndView viewAbout() {
		Map<String, Object> model1 = new HashMap<String, Object>();
		List<Category> list = categoryService.listCategory();
		model1.put("categorys", prepareListofBeanProduct(list));
		return new ModelAndView("aboutus", model1);

	}

	@RequestMapping("/login")
	public String viewLogin(Model model) {
		model.addAttribute("User", new UserMaster());
		return "login";
	}

	@RequestMapping("/register")
	public String viewRegister(Model model) {
		model.addAttribute("User", new UserMaster());
		return "register";
	}

	@RequestMapping("/forgetpassword")
	public String viewForgotPassword() {
		return "forgetpassword";
	}

//	all temp design mapping

	@RequestMapping("/cart")
	public ModelAndView viewCart() {
		Map<String, Object> model1 = new HashMap<String, Object>();

		List<Category> list = categoryService.listCategory();
		System.out.println("Done");
		model1.put("categorys", prepareListofBeanProduct(list));
		return new ModelAndView("cart", model1);

	}

	@RequestMapping("/checkout")
	public String viewCheckout() {
		return "checkout";
	}

	@RequestMapping("/contact")
	public ModelAndView viewContact()

	{

		Map<String, Object> model1 = new HashMap<String, Object>();

		List<Category> list = categoryService.listCategory();
		System.out.println("Done");
		model1.put("categorys", prepareListofBeanProduct(list));
		return new ModelAndView("contact", model1);

	}

	@RequestMapping("/detail")
	public String viewDetails() {
		return "detail";
	}

	@RequestMapping("/shop")
	public ModelAndView viewShop() {
		Map<String, Object> model1 = new HashMap<String, Object>();

		List<Category> list = categoryService.listCategory();
		System.out.println("Done");
		model1.put("categorys", prepareListofBeanProduct(list));
		return new ModelAndView("shop", model1);

	}

	@RequestMapping("/search2")
	public ModelAndView viewsearchs() {
		Map<String, Object> model1 = new HashMap<String, Object>();
		List<Category> list = categoryService.listCategory();
		System.out.println("Done");
		model1.put("categorys", prepareListofBeanProduct(list));
		return new ModelAndView("search2", model1);

	}


	@RequestMapping("/search")
	public ModelAndView viewsearch(Model model) {
		Map<String, Object> model1 = new HashMap<String, Object>();
		List<SubproductMaster> list = subProductService.listSubProduct();
		
		
		// update code
		if(list!=null&& !list.isEmpty()) {
			for (SubproductMaster subproductMaster1 : list) {
				byte[] encodeBase64 = Base64.encodeBase64(subproductMaster1.getImagestore());
				String base64Encoded = null;
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				subproductMaster1.setSubproductImage(String.valueOf(base64Encoded));
				model.addAttribute("subProductImage",subproductMaster1.getSubproductImage());
				
			}
		}	
		
		
		List<Category> list1 = categoryService.listCategory();
		model1.put("categorys", prepareListofBeanProduct(list1));
		model1.put("subproducts", prepareListofBean2(list));
		model.addAttribute("SubProduct", new SubproductMaster());
		return new ModelAndView("search", model1);
	}


	private List<SubproductMasterBean> prepareListofBean2(List<SubproductMaster> sub) {
		List<SubproductMasterBean> beans = null;
		if (sub != null && !sub.isEmpty()) {
			beans = new ArrayList<SubproductMasterBean>();
			SubproductMasterBean bean = null;
			for (SubproductMaster subproductMaster : sub) {
				bean = new SubproductMasterBean();
				bean.setSubproductId(subproductMaster.getSubproductId());
				bean.setSubproductName(subproductMaster.getSubproductName());
				bean.setSubproductPrice(subproductMaster.getSubproductPrice());
				byte[] encodeBase64 = Base64.encodeBase64(subproductMaster.getImagestore());
				String base64Encoded = null;
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bean.setSubproductImage(String.valueOf(base64Encoded));
				bean.setSubproductQuantity(subproductMaster.getSubproductQuantity());
				beans.add(bean);
			}
		}
		return beans;
	}

}
