package com.rapid.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapid.bean.SubproductMasterBean;
import com.rapid.model.SubproductMaster;

@Repository("subProductDao")
public class SubProductDaoImpl implements SubProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Autowired
	GeneralImp generalImp;

	@Override
	@SuppressWarnings("unchecked")
	public List<SubproductMaster> listSubProduct() {
		String sqlQuery = "from SubproductMaster";
		List<SubproductMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);
		return list;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<SubproductMaster> listSearchSubProduct(SubproductMasterBean subProduct) {
		String productString=subProduct.getSubproductName();
		String sqlQuery = "FROM SubproductMaster WHERE subproductName LIKE '"+productString+"%'";
		List<SubproductMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);
	
		
//		Iterator itr = list.iterator();
//		while (itr.hasNext()) {
//
//			Object[] obj = (Object[]) itr.next();
//			
//			
//				System.out.println(String.valueOf(obj[0]));
//				System.out.println(String.valueOf(obj[1]));
//				System.out.println(String.valueOf(obj[2]));
//				System.out.println(String.valueOf(obj[3]));
//				System.out.println(String.valueOf(obj[4]));
//				System.out.println(String.valueOf(obj[6]));
//			}
//		
//		
		
		
		return list;
	}
	
	@Override
	public SubproductMaster getSingleSubProduct(Integer subproductId) {		
		return (SubproductMaster) generalImp.getById(SubproductMaster.class, subproductId, sessionFactory);
	}
}
