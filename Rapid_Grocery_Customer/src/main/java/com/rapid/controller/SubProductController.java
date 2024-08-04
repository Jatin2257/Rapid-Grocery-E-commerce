package com.rapid.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rapid.bean.CategoryBean;
import com.rapid.bean.SubproductMasterBean;
import com.rapid.model.Cart;
import com.rapid.model.Category;
import com.rapid.model.SubproductMaster;
import com.rapid.service.CategoryService;
import com.rapid.service.SubProductService;

@Controller
public class SubProductController {

	@Autowired
	private SubProductService subProductService;

	@Autowired
	private CategoryService categoryService;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView viewAllSubproduct() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		List<SubproductMaster> list = subProductService.listSubProduct();
//		model.put("subproducts", prepareListofBean1(list));
//		return new ModelAndView("home", model);
//	}

// for display product
	@RequestMapping(value = "/viewSubProduct", method = RequestMethod.GET)
	public ModelAndView viewSubProduct(SubproductMasterBean subProduct, BindingResult result) {
		SubproductMaster SubProduct = subProductService.getSingleSubProduct(subProduct.getSubproductId());
		byte[] encodeBase64 = Base64.encodeBase64(SubProduct.getImagestore());
		String base64Encoded = null;
		try {
			base64Encoded = new String(encodeBase64, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SubProduct.setSubproductImage(String.valueOf(base64Encoded));
		Map<String, Object> model = new HashMap<String, Object>();

		model.put("subproduct", SubProduct);
		model.put("Cart", new Cart());
		return new ModelAndView("detail", model);
	}

	@RequestMapping(value = "/searchs", method = RequestMethod.POST)
	public ModelAndView insertCategory(@ModelAttribute("SubProduct") SubproductMasterBean subProduct,
			BindingResult bindingResult) {

		Map<String, Object> model = new HashMap<String, Object>();

		List<SubproductMaster> list = subProductService.listSearchSubProduct(subProduct);
		
		// update code
		if(list!=null&& !list.isEmpty()) {
			for (SubproductMaster subproductMaster1 : list) {
				byte[] encodeBase64 = Base64.encodeBase64(subproductMaster1.getImagestore());
				String base64Encoded = null;
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				subproductMaster1.setSubproductImage(String.valueOf(base64Encoded));
				model.put("subProductImage",subproductMaster1.getSubproductImage());
			}
		}
		
		
		System.out.println("Done till here");
//		model.put("subproducts", prepareListofBean2(list));
		List<Category> list1 = categoryService.listCategory();

		model.put("categorys", prepareListofBeanProduct(list1));
		model.put("subproducts", list);
		return new ModelAndView("search", model);
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
				byte[] encodeBase64 = Base64.encodeBase64(subproductMaster.getImagestore());
				String base64Encoded = null;
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bean.setSubproductImage(String.valueOf(base64Encoded));
				beans.add(bean);
			}
		}
		return beans;
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

	private List<SubproductMasterBean> prepareListofBean2(List<SubproductMaster> cat) {
		List<SubproductMasterBean> beans = null;
		if (cat != null && !cat.isEmpty()) {
			beans = new ArrayList<SubproductMasterBean>();
			SubproductMasterBean bean = null;
			Iterator itr = cat.iterator();
			while (itr.hasNext()) {
				bean = new SubproductMasterBean();
				Object[] obj = (Object[]) itr.next();

				bean.setSubproductId(Integer.parseInt(String.valueOf(obj[3])));
				bean.setSubproductName(String.valueOf(obj[5]));
				bean.setSubproductPrice(Integer.parseInt(String.valueOf(obj[6])));
				bean.setSubproductQuantity(Integer.parseInt(String.valueOf(obj[7])));
				bean.setSubproductDescription(String.valueOf(obj[2]));
				byte[] encodeBase64 = Base64.encodeBase64((byte[]) obj[9]);
				String base64Encoded = null;
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bean.setSubproductImage(String.valueOf(base64Encoded));
				bean.setProductId(Integer.parseInt(String.valueOf(obj[0])));
				bean.setProductName(String.valueOf(obj[1]));

				beans.add(bean);
			}
		}
		return beans;
	}

//	private List<SubproductMasterBean> prepareListofBean2(List<SubproductMaster> cat) {
//		List<SubproductMasterBean> beans = null;
//		if (cat != null && !cat.isEmpty()) {
//			beans = new ArrayList<SubproductMasterBean>();
//			SubproductMasterBean bean = null;
//			Iterator itr = cat.iterator();
//			while (itr.hasNext()) {
//				bean = new SubproductMasterBean();
//				Object[] obj = (Object[]) itr.next();
//				int i = 0;
//
//				bean.setSubproductId(Integer.parseInt(String.valueOf(obj[0])));
//				bean.setSubproductName(String.valueOf(obj[1]));
//				bean.setSubproductPrice(Integer.parseInt(String.valueOf(obj[2])));
//				bean.setSubproductQuantity(Integer.parseInt(String.valueOf(obj[3])));
//				bean.setSubproductDescription(String.valueOf(obj[4]));
//				bean.setSubproductImage(String.valueOf(obj[5]));
//				bean.setProductId(Integer.parseInt(String.valueOf(obj[7])));
//				bean.setProductName(String.valueOf(obj[8]));
//
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}

}
