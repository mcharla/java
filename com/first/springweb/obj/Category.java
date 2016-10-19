package com.first.springweb.obj;

public class Category {

	private String categoryId;
	private String categoryName;
	
	public Category() {
		super();
	}
	
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

}
