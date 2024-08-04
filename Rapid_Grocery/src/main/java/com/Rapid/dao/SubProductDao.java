package com.Rapid.dao;

import java.util.List;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.model.Category;
import com.Rapid.model.SubproductMaster;

public interface SubProductDao {
	
	public void addSubProduct(SubproductMasterBean subProduct);
	
	public List<SubproductMaster> listSubProduct();
	
	public void deleteSubProduct(Integer categoryId);

	public SubproductMaster getSubProduct(Integer categoryId);
	public Long subproductcount();
}
