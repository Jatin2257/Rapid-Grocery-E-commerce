package com.Rapid.bean;

public class SubproductMasterBean {

	private Integer subproductId;
	private String subproductName;
	private Integer subproductPrice;
	private Integer subproductQuantity;
	private String subproductDescription;
	private Integer productId;
	private String productName;
	private	byte[] imagestore;

	public byte[] getImagestore() {
		return imagestore;
	}

	public void setImagestore(byte[] imagestore) {
		this.imagestore = imagestore;
	}

	private String subproductImage;


	public String getSubproductImage() {
		return subproductImage;
	}

	public void setSubproductImage(String subproductImage) {
		this.subproductImage = subproductImage;
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

	public Integer getSubproductPrice() {
		return subproductPrice;
	}

	public void setSubproductPrice(Integer subproductPrice) {
		this.subproductPrice = subproductPrice;
	}

	public Integer getSubproductQuantity() {
		return subproductQuantity;
	}

	public void setSubproductQuantity(Integer subproductQuantity) {
		this.subproductQuantity = subproductQuantity;
	}

	public Integer getSubproductId() {
		return subproductId;
	}

	public void setSubproductId(Integer subproductId) {
		this.subproductId = subproductId;
	}

	public String getSubproductName() {
		return subproductName;
	}

	public void setSubproductName(String subproductName) {
		this.subproductName = subproductName;
	}

	public String getSubproductDescription() {
		return subproductDescription;
	}

	public void setSubproductDescription(String subproductDescription) {
		this.subproductDescription = subproductDescription;
	}

}
