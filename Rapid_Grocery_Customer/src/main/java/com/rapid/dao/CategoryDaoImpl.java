package com.rapid.dao;




import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rapid.model.Category;

@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	@Autowired
	GeneralImp generalImp;

	@Override
	@SuppressWarnings({ "unchecked" })
	public List<Category> listCategory() {
		
		String sqlQuery = "from Category";

		List<Category> list = generalImp.getListByHQL(sqlQuery, sessionFactory);

//		Iterator itr = list.iterator();
//		while (itr.hasNext()) {
//
//			Object[] obj = (Object[]) itr.next();
//			
//			System.out.println(String.valueOf(obj[0]));
//
//			System.out.println(String.valueOf(obj[1]));
//			System.out.println(String.valueOf(obj[2]));
//
//		}

		return list;
	}
}

