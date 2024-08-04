package com.Rapid.model;



import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "subproduct_master")
public class SubproductMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subproduct_id")
	Integer subproductId;
	
	@Column(name = "subproduct_name")
	String subproductName;
	
	@Column(name = "subproduct_description")
	String subproductDescription;
	
	 //foreign
	@Column(name = "subproduct_price")
	private	Integer subproductPrice;
	
	@Column(name = "subproduct_quantity")
	private	Integer subproductQuantity;
	
	@Column(name = "imagestore")
	private	byte[] imagestore;
	
	
	public byte[] getImagestore() {
		return imagestore;
	}

	public void setImagestore(byte[] imagestore) {
		this.imagestore = imagestore;
	}

	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "subproduct_image")
	private String subproductImage;
	
	@Transient
	private String productName;
	
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

	public Integer getSubproductId() {
		return subproductId;
	}

	public void setSubproductId(Integer subproductId) {
		this.subproductId = subproductId;
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

	@Override
	public String toString() {
		return "SubproductMaster [subproductId=" + subproductId + ", subproductName=" + subproductName
				+ ", subproductDescription=" + subproductDescription + ", subproductPrice=" + subproductPrice
				+ ", subproductQuantity=" + subproductQuantity + ", imagestore=" + Arrays.toString(imagestore)
				+ ", productId=" + productId + ", subproductImage=" + subproductImage + ", productName=" + productName
				+ "]";
	}

	
	
	
}
