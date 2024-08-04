package com.Rapid.dao;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Rapid.bean.CategoryBean;
import com.Rapid.bean.ProductMasterBean;
import com.Rapid.model.Category;
import com.Rapid.model.ProductMaster;
import com.Rapid.model.SubproductMaster;

@Repository("productDao")
public class ProductDaoImpl  implements ProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	GeneralImp generalImp;
	
	public void addProduct(ProductMasterBean productbean ) {
		ProductMaster product = covertFomBeanToModel (productbean); 
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	private ProductMaster covertFomBeanToModel(ProductMasterBean productbean) {
		ProductMaster product = new ProductMaster();
		product.setProductId(productbean.getProductId());
		product.setProductName(productbean.getProductName());
		product.setProductDescription(productbean.getProductDescription());
		product.setCategory(productbean.getCategoryId());
			
		return product;
	}
	
	   @Override
	@SuppressWarnings({ "unchecked" })
	public List<ProductMaster> listProduct() {
		  
		   String sqlQuery = "SELECT pm.productId, pm.productDescription, pm.productName, "+
	                       "  pm.categoryId, c.categoryId, c.categoryName from ProductMaster pm "+
			   " INNER JOIN Category c ON pm.categoryId = c.categoryId";
		   
		   //"SELECT um.userMasterId,um.userMasterFirstName, um.userMasterLastName, um.userEmailId, "+
         //  "  um.userContact,um.userDOB,um.userPassword,um.userTId, um.userSalary, um.isActive, "
          // + "ut.userTId, ut.userTName from UserMaster um "+
//" INNER JOIN UserType ut ON um.userTId = ut.userTName";

		   
		   List<ProductMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);
		   
//		   List<ProductMaster> list = (List<ProductMaster>) sessionFactory.getCurrentSession().createQuery(sqlQuery).getResultList();
//		   List<Object> result = (List<Object>) sessionFactory.getCurrentSession().createQuery(sqlQuery).getResultList();
		  
		   
		   return list;
	}
	   @Override
	@SuppressWarnings("unchecked")
	public List<ProductMaster> listProduct1() {
		   String sqlQuery="From ProductMaster";
		   List<ProductMaster> list = generalImp.getListByHQL(sqlQuery, sessionFactory);
  //return (List<ProductMaster>) sessionFactory.getCurrentSession().createCriteria(ProductMaster.class).list();
   return list;
}
	   

	@Override
	public void deleteProduct(Integer productId) {
		String hqlQueryString = "DELETE FROM ProductMaster WHERE productId = "+productId;
		generalImp.deleteByHQL(hqlQueryString, sessionFactory);
	}
	
	@Override
	public ProductMaster getProduct(Integer productId) {
		return (ProductMaster) generalImp.getById(ProductMaster.class, productId, sessionFactory);
	}
	@Override
	public Long subproductcount() {
		
			
		      
			   
		    String sqlString="SELECT count(productId) FROM ProductMaster";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(sqlString);
			Iterator count = query.iterate();
			//System.out.println("No. of rows : "+count.next()); 
			Long i = (Long) count.next();
			System.out.println(i);
			return i;
		
	}
}
