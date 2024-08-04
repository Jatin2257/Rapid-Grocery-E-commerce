package com.rapid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rapid.bean.SubproductMasterBean;
import com.rapid.model.SubproductMaster;

@Service
public interface SubProductService {
	
	public List<SubproductMaster> listSubProduct();
	
	public List<SubproductMaster> listSearchSubProduct(SubproductMasterBean subProduct);
	
	public SubproductMaster getSingleSubProduct(Integer subProductId);
}
