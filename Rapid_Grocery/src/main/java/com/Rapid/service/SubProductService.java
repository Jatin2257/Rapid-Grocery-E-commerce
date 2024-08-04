package com.Rapid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.model.Category;
import com.Rapid.model.SubproductMaster;

@Service
public interface SubProductService {

	public void addSubProduct(SubproductMasterBean subProduct);
	
	public List<SubproductMaster> listSubProduct();
	
	public void deleteSubProduct(Integer subProductId);

	public SubproductMaster getSubProduct(Integer subProductId);


	public Long subproductcount();
}
