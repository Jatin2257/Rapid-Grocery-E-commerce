package com.Rapid.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.SubproductMasterBean;
import com.Rapid.model.Category;
import com.Rapid.model.ProductMaster;
import com.Rapid.model.SubproductMaster;

@Repository("subProductDao")
public class SubProductDaoImpl implements SubProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	GeneralImp generalImp;

	public void addSubProduct(SubproductMasterBean subProduct) {
		System.out.println("image stoew hushdshidhs"+subProduct);
		SubproductMaster subproduct = covertFomBeanToModel(subProduct);
		sessionFactory.getCurrentSession().saveOrUpdate(subproduct);
	}

	private SubproductMaster covertFomBeanToModel(SubproductMasterBean subProduct) {
		SubproductMaster subproduct = new SubproductMaster();
		subproduct.setSubproductId(subProduct.getSubproductId());
		subproduct.setSubproductName(subProduct.getSubproductName());
		subproduct.setSubproductDescription(subProduct.getSubproductDescription());
		subproduct.setSubproductPrice(subProduct.getSubproductPrice());
		subproduct.setSubproductQuantity(subProduct.getSubproductQuantity());
		subproduct.setSubproductImage(subProduct.getSubproductImage());
		subproduct.setImagestore(subProduct.getImagestore());
		subproduct.setProductId(subProduct.getProductId());

		return subproduct;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SubproductMaster> listSubProduct() {

		String sqlQuery = "SELECT sm.subproductId, sm.subproductName, sm.subproductPrice,sm.subproductQuantity, sm.subproductDescription,"
				+ "  sm.productId, pm.productId, pm.productName, sm.subproductImage ,sm.imagestore from SubproductMaster sm "
				+ " INNER JOIN ProductMaster pm ON sm.productId = pm.productId";

		List<SubproductMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);

		return list;

	}

	@Override
	public void deleteSubProduct(Integer subproductId) {
		String hqlQueryString = "DELETE FROM SubproductMaster WHERE subproductId = " + subproductId;
		generalImp.deleteByHQL(hqlQueryString, sessionFactory);
	}

	@Override
	public SubproductMaster getSubProduct(Integer subproductId) {
		return (SubproductMaster) generalImp.getById(SubproductMaster.class, subproductId, sessionFactory);
	}

	@Override
	public Long subproductcount() {

		String sqlString = "SELECT count(subproductId) FROM SubproductMaster";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sqlString);
		Iterator count = query.iterate();
		// System.out.println("No. of rows : "+count.next());
		Long i = (Long) count.next();
		System.out.println(i);
		return i;
	}

}
