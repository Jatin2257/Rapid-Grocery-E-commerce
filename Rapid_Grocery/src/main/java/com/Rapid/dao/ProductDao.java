package com.Rapid.dao;

import java.util.List;

import com.Rapid.bean.ProductMasterBean;
import com.Rapid.model.ProductMaster;

public interface ProductDao {

	public void addProduct(ProductMasterBean product);
	
	public List<ProductMaster> listProduct();
	
	public List<ProductMaster> listProduct1();
	
	public void deleteProduct(Integer categoryId);

	public ProductMaster getProduct(Integer categoryId);
	public Long subproductcount();

}
