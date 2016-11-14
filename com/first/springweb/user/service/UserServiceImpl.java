package com.first.springweb.user.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.first.springweb.obj.CategoryBO;
import com.first.springweb.obj.ProductBO;
import com.first.springweb.obj.User;
import com.first.springweb.user.dao.UserDAO;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;

	public List<ProductBO> listAllProducts() throws SQLException {
		return userDAO.listAllProducts();
	}

	public List<CategoryBO> listAllCategories() {
		return userDAO.listAllCategories();

	}

	public ProductBO findProductById(Long Id) {
		return userDAO.findProductById(Id);
	}

	public ProductBO findProductByName(String productName) {
		return userDAO.findProductByName(productName);
	}

	public List<ProductBO> findProductsByCategory(String categoryName) {
		return userDAO.findProductsByCategory(categoryName);
	}

	public List<ProductBO> stockLessThanTen() {
		return userDAO.stockLessThanTen();
	}

	public List<ProductBO> expiringInFiveDays() {
		return userDAO.expiringInFiveDays();
	}
	
	public User addUser(){
		return userDAO.addUser();
	}

}
