package com.rapid.bean;



public class ProductMasterBean {
	
	private Integer productId;
	private String productName;
	private String productDescription;
	private Integer categoryId;
	String categoryName;
	
	
	
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	
	
	public Integer getCategory() {
		return categoryId;
	}

	public void setCategory(Integer category) {
		this.categoryId = category;
	}

}


