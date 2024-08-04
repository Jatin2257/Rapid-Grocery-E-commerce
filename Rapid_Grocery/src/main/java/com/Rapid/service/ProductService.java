package com.Rapid.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Rapid.bean.ProductMasterBean;

import com.Rapid.model.ProductMaster;

@Service
public interface ProductService {
	
	public List<ProductMaster> listProduct();
	
	public List<ProductMaster> listProduct1();
	
	public void deleteProduct(Integer productId);

	public ProductMaster getProduct(Integer productId);

	public void addProduct(ProductMasterBean product);

	public Long productcount();
}
