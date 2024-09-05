package com.webProject.myapplication.modal;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="product_modal")
public class ProductModal {
	
	@Id
	@Column(name="prodId")
	private int prodId;
	@Column(name="prodName")
	private String prodName;
	@Column(name="prodPrice")
	private int prodPrice;
	
	public ProductModal() {
		
	}
	
	public ProductModal(int prodId, String prodName, int prodPrice) {

		this.prodId = prodId;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	
}
