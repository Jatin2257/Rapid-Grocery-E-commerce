package com.rapid.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.rapid.bean.ProductMasterBean;

import com.rapid.model.ProductMaster;

@Service
public interface ProductService {
	
	public List<ProductMaster> listProduct();
	
	public List<ProductMaster> listProduct1();
	
	public void deleteProduct(Integer productId);

	public List<ProductMaster> getProduct(Integer productId);

	public void addProduct(ProductMasterBean product);


}
