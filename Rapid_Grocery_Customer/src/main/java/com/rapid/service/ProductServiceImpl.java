package com.rapid.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.rapid.bean.ProductMasterBean;

import com.rapid.dao.ProductDao;

import com.rapid.model.ProductMaster;

@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	//add Category
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProduct (ProductMasterBean  product) {
		productDao.addProduct(product);
	}

	@Override
	public List<ProductMaster> listProduct() {
		return productDao.listProduct();
	}
	
	@Override
	public List<ProductMaster> listProduct1() {
		return productDao.listProduct1();
	}
	

	@Override
	@Transactional
	public void deleteProduct(Integer productId) {
		productDao.deleteProduct(productId);
	}

	@Override
	public List<ProductMaster> getProduct(Integer productId) {
		return productDao.getProduct(productId);	}	

	

}
