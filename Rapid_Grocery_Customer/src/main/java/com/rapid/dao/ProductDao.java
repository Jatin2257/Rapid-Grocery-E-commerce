package com.rapid.dao;



import java.util.List;

import com.rapid.bean.ProductMasterBean;
import com.rapid.model.ProductMaster;

public interface ProductDao {

	public void addProduct(ProductMasterBean product);
	
	public List<ProductMaster> listProduct();
	
	public List<ProductMaster> listProduct1();
	
	public void deleteProduct(Integer categoryId);

	public List<ProductMaster> getProduct(Integer categoryId);


}


