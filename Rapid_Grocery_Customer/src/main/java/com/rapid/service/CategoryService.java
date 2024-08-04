package com.rapid.service;



import java.util.List;

import org.springframework.stereotype.Service;


import com.rapid.model.Category;

@Service
public interface CategoryService {
	
	public List<Category> listCategory();

}

