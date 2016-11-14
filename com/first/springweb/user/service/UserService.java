package com.first.springweb.user.service;

import java.sql.SQLException;
import java.util.List;

import com.first.springweb.obj.CategoryBO;
import com.first.springweb.obj.ProductBO;
import com.first.springweb.obj.User;

public interface UserService {
	
	public List<ProductBO> listAllProducts() throws SQLException;

	public List<CategoryBO> listAllCategories();

	public ProductBO findProductById(Long Id); //admin

	public ProductBO findProductByName(String productName);
	 
	public List<ProductBO> findProductsByCategory(String categoryName);

	public List<ProductBO> stockLessThanTen();

	public List<ProductBO> expiringInFiveDays();
	
	public User addUser();

}
