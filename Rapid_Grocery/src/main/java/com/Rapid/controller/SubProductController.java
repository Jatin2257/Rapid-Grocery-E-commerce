package com.Rapid.controller;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Rapid.bean.LoggerInfo;
import com.Rapid.bean.ProductMasterBean;
import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.model.ProductMaster;
import com.Rapid.model.SubproductMaster;
import com.Rapid.service.ProductService;
import com.Rapid.service.SubProductService;

@Controller
public class SubProductController {

	String path = "C:\\rapidimages\\";

	@Autowired
	private HttpSession session;

	@Autowired
	private ProductService productService;
	@Autowired
	private SubProductService subProductService;

	@RequestMapping(value = "/addsubproduct", method = RequestMethod.POST)
	public ModelAndView insertCategory(@RequestParam("imgupload") CommonsMultipartFile file,
			@ModelAttribute("SubProduct") SubproductMasterBean subProduct, BindingResult bindingResult)
			throws IOException {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			/*
			 * byte barr[]=file.getBytes(); BufferedOutputStream bout =new
			 * BufferedOutputStream(new FileOutputStream(new File(path + File.separator +
			 * file.getOriginalFilename()))); bout.write(barr); bout.flush(); bout.close();
			 */
			subProduct.setSubproductImage(file.getOriginalFilename());
			subProduct.setImagestore(file.getBytes());

			subProductService.addSubProduct(subProduct);
			Map<String, Object> model = new HashMap<String, Object>();

			List<SubproductMaster> list1 = subProductService.listSubProduct();
			/*
			 * for (int i = 0; i < list1.size(); i++) {
			 * 
			 * String base64Encoded = null; if (list1.get(i).getImagestore() != null) {
			 * byte[] encodeBase64 = Base64.encodeBase64(list1.get(i).getImagestore()); try
			 * { base64Encoded = new String(encodeBase64, "UTF-8");
			 * list1.get(i).setSubproductImage(base64Encoded); } catch
			 * (UnsupportedEncodingException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } }
			 */
			model.put("subproducts", prepareListofBean2(list1));
			return new ModelAndView("subproduct_list", model);
		}
		return new ModelAndView("redirect:/signin");
	}

//	

	@RequestMapping(value = "/subproduct_list", method = RequestMethod.GET)
	public ModelAndView viewAllSubproduct() {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {

			Map<String, Object> model = new HashMap<String, Object>();
			List<SubproductMaster> list1 = subProductService.listSubProduct();

			/*
			 * for (int i = 0; i < list1.size(); i++) {
			 * 
			 * String base64Encoded = null; if (list1.get(i).getImagestore() != null) {
			 * byte[] encodeBase64 = Base64.encodeBase64(list1.get(i).getImagestore()); try
			 * { base64Encoded = new String(encodeBase64, "UTF-8");
			 * list1.get(i).setSubproductImage(base64Encoded); } catch
			 * (UnsupportedEncodingException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } }
			 */

			model.put("subproducts", prepareListofBean2(list1));
			return new ModelAndView("subproduct_list", model);
		}
		return new ModelAndView("redirect:/signin");
	}

	public List<SubproductMaster> convertImageBase64(List<SubproductMaster> list1) {
		for (int i = 0; i < list1.size(); i++) {

			String base64Encoded = null;
			if (list1.get(i).getImagestore() != null) {
				byte[] encodeBase64 = Base64.encodeBase64(list1.get(i).getImagestore());
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
					list1.get(i).setSubproductImage(base64Encoded);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list1;
	}

	// for delete
	@RequestMapping(value = "/deleteSubProduct", method = RequestMethod.GET)
	public ModelAndView deleteSubProduct(@ModelAttribute("SubProduct") SubproductMasterBean subproduct,
			BindingResult result) {

		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {
			subProductService.deleteSubProduct(subproduct.getSubproductId());
			Map<String, Object> model = new HashMap<String, Object>();
			List<SubproductMaster> list = subProductService.listSubProduct();
			model.put("subproduct", null);
			model.put("subproducts", prepareListofBean2(list));
			return new ModelAndView("redirect:/subproduct_list");
		}
		return new ModelAndView("redirect:/signin");

	}

	// for edit
	@RequestMapping(value = "/editSubProduct", method = RequestMethod.GET)
	public ModelAndView editCategory(@ModelAttribute("SubProduct") SubproductMasterBean subProduct,
			BindingResult result) {
		LoggerInfo loggerInfo = (LoggerInfo) session.getAttribute("LoggerInfo");
		if (null != loggerInfo) {

			SubproductMaster SubProduct = subProductService.getSubProduct(subProduct.getSubproductId());
			subProduct.setSubproductId(subProduct.getSubproductId());
			subProduct.setSubproductName(subProduct.getSubproductName());
			subProduct.setSubproductDescription(subProduct.getSubproductDescription());
			subProduct.setSubproductPrice(subProduct.getSubproductPrice());
			subProduct.setSubproductQuantity(subProduct.getSubproductQuantity());
			subProduct.setProductId(subProduct.getProductId());
			subProduct.setProductName(subProduct.getProductName());

			Map<String, Object> model = new HashMap<String, Object>();
			List<ProductMaster> list1 = productService.listProduct1();
			model.put("products", prepareListofBean1(list1));
			model.put("subproduct", SubProduct);
			return new ModelAndView("subproduct2", model);
		}
		return new ModelAndView("redirect:/signin");
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
				byte[] encodeBase64 = Base64.encodeBase64((byte[]) obj[9]);
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
