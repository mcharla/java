package com.first.springweb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.first.springweb.dao.WarehouseDAO;
import com.first.springweb.obj.CategoryBO;
import com.first.springweb.obj.ProductBO;

public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseDAO wareHouseDAO;
	
	public ProductBO findProductById(Long Id) throws SQLException {
		return wareHouseDAO.findProductById(Id);
	}

	public ProductBO findProductByName(String productName) throws SQLException {
		return wareHouseDAO.findProductByName(productName);
	}

	public List<ProductBO> findProductsByCategory(String categoryName) throws SQLException {
		return wareHouseDAO.findProductsByCategory(categoryName);
	}

	public int addProduct(ProductBO product)   throws Exception{
		return wareHouseDAO.insertProduct(product);
	}

	public List<ProductBO> getAllProducts() throws SQLException {
		return wareHouseDAO.getAllProducts();
	}

	public Map<String, List<ProductBO>> getAllProductsCategoryWise() throws SQLException {
		return wareHouseDAO.getAllProductsCategoryWise();
	}

	public int setproductPrice(Long prodcutId, Double productPrice) throws SQLException {
		return wareHouseDAO.setproductPrice(prodcutId, productPrice);
	}

	public void setWareHouseDAO(WarehouseDAO wareHouseDAO) {
		this.wareHouseDAO = wareHouseDAO;
	}

	public int addCategory(CategoryBO category) throws Exception {
		return wareHouseDAO.insertCategory(category);
	}

	public List<String> getCategories() {
		return wareHouseDAO.getAllCategories();
	}

	public boolean categoryExists(Long categoryId) {
		return wareHouseDAO.checkCategory(categoryId);
	}

	public boolean productExists(Long productId) {
		
		return wareHouseDAO.checkProduct(productId);
	}

	public boolean stockFormat(Long productStock) {
		return wareHouseDAO.stockFormat(productStock);
	}

	public boolean priceFormat(Double productPrice) {
		return wareHouseDAO.priceFormat(productPrice);
	}
	
}
