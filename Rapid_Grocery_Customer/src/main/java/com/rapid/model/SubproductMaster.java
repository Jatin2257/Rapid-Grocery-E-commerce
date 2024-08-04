package com.rapid.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name = "subproduct_master")
public class SubproductMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subproduct_id")
	public Integer subproductId;
	
	@Column(name = "subproduct_name")
	public String subproductName;
	
	@Column(name = "subproduct_description")
	@Size()
	public String subproductDescription;
	
	 //foreign
	@Column(name = "subproduct_price")
	public	Integer subproductPrice;
	
	@Column(name = "subproduct_quantity")
	public	Integer subproductQuantity;
	
	@Column(name = "product_id")
	public Integer productId;
	
	@Column(name = "subproduct_image")
	public String subproductImage;
	
	@Column(name = "imagestore")
	public byte[] imagestore;
	
	@Transient
	public String productName;
	
	
	
	public byte[] getImagestore() {
		return imagestore;
	}

	public void setImagestore(byte[] imagestore) {
		this.imagestore = imagestore;
	}

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

	
	
	
}
