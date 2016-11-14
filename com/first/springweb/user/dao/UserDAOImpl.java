package com.first.springweb.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.first.springweb.obj.CategoryBO;
import com.first.springweb.obj.ProductBO;
import com.first.springweb.obj.User;

public class UserDAOImpl implements UserDAO{

	public List<ProductBO> listAllProducts() throws SQLException {
		return null;	
	}

	public List<CategoryBO> listAllCategories() {
		return null;
	}

	public ProductBO findProductById(Long Id) {
		return null;
	}

	public ProductBO findProductByName(String productName) {
		return null;
	}

	public List<ProductBO> findProductsByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductBO> stockLessThanTen() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ProductBO> expiringInFiveDays() {
		// TODO Auto-generated method stub
		return null;
	}

	public User addUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
