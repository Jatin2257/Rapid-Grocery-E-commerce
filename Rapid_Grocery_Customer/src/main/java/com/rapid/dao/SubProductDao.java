package com.rapid.dao;

import java.util.List;

import com.rapid.bean.SubproductMasterBean;
import com.rapid.model.SubproductMaster;

public interface SubProductDao {
	
	public List<SubproductMaster> listSubProduct();
	
	public List<SubproductMaster> listSearchSubProduct(SubproductMasterBean subProduct);
	
	public SubproductMaster getSingleSubProduct(Integer subproductId);
}
