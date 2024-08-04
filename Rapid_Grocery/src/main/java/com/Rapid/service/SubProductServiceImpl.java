package com.Rapid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.dao.CategoryDao;
import com.Rapid.dao.CategoryDaoImpl;
import com.Rapid.dao.SubProductDao;
import com.Rapid.model.Category;
import com.Rapid.model.SubproductMaster;

@Service("subProductService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SubProductServiceImpl implements SubProductService {
	@Autowired
	private SubProductDao subProductDao;

	//add Category
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addSubProduct(SubproductMasterBean subProduct) {
		subProductDao.addSubProduct(subProduct);
	}

	@Override
	public List<SubproductMaster> listSubProduct() {
		return subProductDao.listSubProduct();
	}

	@Override
	@Transactional
	public void deleteSubProduct(Integer subproductId) {
		subProductDao.deleteSubProduct(subproductId);
	}

	@Override
	public SubproductMaster getSubProduct(Integer subproductId) {
		return subProductDao.getSubProduct(subproductId);
	}

	@Override
	public Long subproductcount() {
		
		return subProductDao.subproductcount();
	}	
}
