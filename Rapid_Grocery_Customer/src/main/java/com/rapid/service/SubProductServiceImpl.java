package com.rapid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rapid.bean.SubproductMasterBean;
import com.rapid.dao.SubProductDao;
import com.rapid.model.SubproductMaster;

@Service("subProductService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SubProductServiceImpl implements SubProductService {
	@Autowired
	private SubProductDao subProductDao;

	@Override
	public List<SubproductMaster> listSubProduct() {
		return subProductDao.listSubProduct();
	}
	
	@Override
	public List<SubproductMaster> listSearchSubProduct(SubproductMasterBean subProduct) {
		return subProductDao.listSearchSubProduct(subProduct);
	}

	@Override
	public SubproductMaster getSingleSubProduct(Integer subProductId) {
		return subProductDao.getSingleSubProduct(subProductId);
	}
	
}
