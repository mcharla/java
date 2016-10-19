package com.first.springweb.obj;

public class Product {
	
	private String productId;
	private String productName;
	private String productPrice;
	private String productLocation;
	private String productStock;
	private Category category;
	private String expiration;
	
	
	public Product(String productId, String productName, String productPrice, String productLocation,
			String productStock, Category category, String expiration) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productLocation = productLocation;
		this.productStock = productStock;
		this.category = category;
		this.expiration = expiration;
	}


	public Product() {
		// TODO Auto-generated constructor stub
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductLocation() {
		return productLocation;
	}


	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}


	public String getProductStock() {
		return productStock;
	}


	public void setProductStock(String productStock) {
		this.productStock = productStock;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getExpiration() {
		return expiration;
	}


	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	
	
	
	
}
