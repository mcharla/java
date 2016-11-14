package com.first.springweb.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.first.springweb.obj.CategoryBO;
import com.first.springweb.obj.ProductBO;


public interface WarehouseDAO {

	public ProductBO findProductById(Long Id) throws SQLException;

	public ProductBO findProductByName(String productName) throws SQLException;

	public List<ProductBO> findProductsByCategory(String categoryName) throws SQLException;
	
	public List<ProductBO> getAllProducts() throws SQLException;
	
	public Map<String, List<ProductBO>> getAllProductsCategoryWise() throws SQLException;

	public int insertProduct(ProductBO p)  throws Exception;
	
	public int insertCategory(CategoryBO category) throws Exception;
	
	public int setproductPrice(Long prodcutId, Double productPrice) throws SQLException;

	public List<String> getAllCategories();

	public boolean checkCategory(Long categoryId);

	public boolean checkProduct(Long productId);

	public  boolean stockFormat(Long productStock);
	
	public boolean priceFormat(Double productPrice);

}