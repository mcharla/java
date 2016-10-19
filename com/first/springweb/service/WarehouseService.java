package com.first.springweb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.first.springweb.obj.CategoryBO;
import com.first.springweb.obj.ProductBO;

public interface WarehouseService {

	public ProductBO findProductById(Long Id) throws SQLException;

	public ProductBO findProductByName(String productName) throws SQLException;

	public List<ProductBO> findProductsByCategory(String categoryName) throws SQLException;

	public List<ProductBO> getAllProducts() throws SQLException;

	public Map<String, List<ProductBO>> getAllProductsCategoryWise() throws SQLException;

	public int addProduct(ProductBO product) throws Exception;
	
	public int addCategory(CategoryBO category) throws Exception;

	public int setproductPrice(Long productId, Double productPrice) throws SQLException;

	public List<String> getCategories();
	
	public boolean categoryExists(Long categoryId);

}
