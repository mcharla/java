package com.first.springweb.obj;

import java.util.Date;

public class ProductBO {
	private Long productId;
	private String productName;
	private Double productPrice;
	private String productLocation;
	private Long productStock;
	private CategoryBO category;
	private Date expiration;
	
	public ProductBO(Long productId, String productName, Double productPrice, String productLocation, Long productStock, Date expiration,
			CategoryBO category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productLocation = productLocation;
		this.productStock = productStock;
		this.category = category;
	}
	public ProductBO() {
		// TODO Auto-generated constructor stub
	}
	public long getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	
	public String getProductLocation() {
		return productLocation;
	}
	public long getProductStock() {
		return productStock;
	}
	public CategoryBO getCategory() {
		return category;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}
	public void setProductStock(Long productStock) {
		this.productStock = productStock;
	}
	public void setCategory(CategoryBO category) {
		this.category = category;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	
	
	}