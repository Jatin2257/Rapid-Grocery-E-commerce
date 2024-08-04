package com.Rapid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.ProductMasterBean;
import com.Rapid.dao.CategoryDao;
import com.Rapid.dao.CategoryDaoImpl;
import com.Rapid.dao.ProductDao;
import com.Rapid.model.Category;
import com.Rapid.model.ProductMaster;

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
	public ProductMaster getProduct(Integer productId) {
		return productDao.getProduct(productId);	}

	@Override
	public Long productcount() {
		// TODO Auto-generated method stub
		return productDao.subproductcount();
	}	

	

}
