package com.Rapid.controller;
import java.util.ArrayList;
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

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.LoggerInfo;
import com.Rapid.bean.ProductMasterBean;
import com.Rapid.model.Category;//please remove this teena
import com.Rapid.model.ProductMaster;
import com.Rapid.service.CategoryService;
import com.Rapid.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public ModelAndView insertProduct(@ModelAttribute("Product") ProductMasterBean product, BindingResult result) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		productService.addProduct(product);
			Map<String, Object> model = new HashMap<String, Object>();
		List<ProductMaster> list = productService.listProduct();
		model.put("products", prepareListofBean(list));
			return new ModelAndView("product_list", model);}
		return new ModelAndView("redirect:/signin");
	}
	
	
	@RequestMapping(value="/product_list", method = RequestMethod.GET)
	public ModelAndView viewAllProduct() {
		
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<ProductMaster> list = productService.listProduct();
		
		model.put("products", prepareListofBean(list));
		
		return new ModelAndView("product_list", model);}
		return new ModelAndView("redirect:/signin");
	}
	
	//for delete
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@ModelAttribute("Product") ProductMasterBean product, BindingResult result) {
		
		
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		productService.deleteProduct(product.getProductId());
		Map<String, Object> model = new HashMap<String, Object>();
		List<ProductMaster> list = productService.listProduct();
		model.put("product", null);
		model.put("products", prepareListofBean(list));
		return new ModelAndView("redirect:/product_list");}
		return new ModelAndView("redirect:/signin");

	}
	
	//for edit
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editProduct(@ModelAttribute("Product") ProductMasterBean product1, BindingResult result) {
		
		
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if(null != loggerInfo) {
		ProductMaster product = productService.getProduct(product1.getProductId());
		product1.setProductId(product.getProductId());
		product1.setProductName(product.getProductName());
		product1.setProductDescription(product.getProductDescription());
			product1.setCategory(product.getCategory());
		
		Map<String, Object> model = new HashMap<String, Object>();
		List<Category> list1 = categoryService.listCategory();
		model.put("categorys", prepareListofBeanProduct(list1));
		model.put("product", product1);
		return new ModelAndView("product", model);}
		return new ModelAndView("redirect:/signin");
	}
		
	private List<CategoryBean> prepareListofBeanProduct(List<Category> cat){
		List<CategoryBean> beans = null;
		if(cat != null && !cat.isEmpty()){
			beans = new ArrayList<CategoryBean>();
			CategoryBean bean = null;
			for(Category product : cat){
				bean = new CategoryBean();
				System.out.println(product.getCategoryId());
				bean.setCategoryId(product.getCategoryId());
				bean.setCategoryName(product.getCategoryName());		
				beans.add(bean);
			}
		}
		return beans;
	}

	
	private List<ProductMasterBean> prepareListofBean(List<ProductMaster> cat) {
		List<ProductMasterBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<ProductMasterBean>();
			ProductMasterBean bean = null;
			Iterator itr = cat.iterator();
			while (itr.hasNext()) {
				bean = new ProductMasterBean();
				Object[] obj = (Object[]) itr.next();
				bean.setProductId(Integer.parseInt(String.valueOf(obj[0])));
				
				bean.setProductDescription(String.valueOf(obj[1]));
				bean.setProductName(String.valueOf(obj[2]));
				bean.setCategoryName(String.valueOf(obj[5]));
				beans.add(bean);
			}
		}
		return beans;
	}
	
	
	
//	private Category prepareModel(CategoryBean categoryBean) {
//		Category category = new Category();
//		category.setProductId(categoryBean.getProductId());
//		category.setProductName(categoryBean.getProductName());
//		categoryBean.setProductId(null);
//		return category;
//	}
	
//	private CategoryBean prepareCategoryBean(Category category){
//		CategoryBean bean = new CategoryBean();
//		bean.setProductId(category.getProductId());
//		bean.setProductName(category.getProductName());
//		return bean;
//	}
	
}




	
	

