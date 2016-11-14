package com.first.springweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.first.springweb.obj.Category;
import com.first.springweb.obj.CategoryBO;
import com.first.springweb.obj.ProductBO;

public class WarehouseDAOImpl implements WarehouseDAO {
	public static List<ProductBO> products;
	public static List<Category> categories;

	public ProductBO findProductById(Long id) throws SQLException {
		products = getAllProducts();
		for (ProductBO product : products) {
			if (id.equals(product.getProductId()))
				return product;
		}
		return null;
	}

	public ProductBO findProductByName(String productName) throws SQLException {
		products = getAllProducts();
		for (ProductBO product : products) {
			if (productName.equals(product.getProductName())) {
				return product;
			}
		}
		return null;
	}

	public int insertProduct(ProductBO p) throws Exception {

		Connection conn = BaseDAO.getConnection();
		Statement stmt = (Statement) conn.createStatement();

		Long categoryID = getCategoryId(p.getCategory(), stmt);
		String query = "insert into product(product_id, product_name, category_id, stock, expiration_date, price, location) values( ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		ps.setLong(1, p.getProductId());
		ps.setString(2, p.getProductName());
		ps.setLong(3, categoryID);
		ps.setLong(4, p.getProductStock());
		ps.setDate(5, p.getExpiration() == null ? null : new java.sql.Date(p.getExpiration().getTime()));
		ps.setDouble(6, p.getProductPrice());
		ps.setString(7, p.getProductLocation());

		return ps.executeUpdate();

	}

	private Long getCategoryId(CategoryBO category, Statement stmt) throws SQLException {
		ResultSet rs = stmt.executeQuery(
				"select category_id from category where category_name = '" + category.getCategoryName() + "'");
		if (rs.next()) {
			return rs.getLong(1);
		}
		return new Long(0);
	}

	private int insertCategory(CategoryBO c, Statement stmt) throws SQLException {
		if (stmt == null) {
			Connection conn = BaseDAO.getConnection();
			stmt = (Statement) conn.createStatement();
		}
		String query = "insert into category(category_id, category_name) values( ";
		StringBuilder builder = new StringBuilder(query);
		builder.append(c.getCategoryId()).append(",");
		builder.append("'").append(c.getCategoryName()).append("'");
		builder.append(" )");
		System.out.println(builder.toString());
		return stmt.executeUpdate(builder.toString());
	}

	public List<ProductBO> findProductsByCategory(String categoryName) throws SQLException {
		Map<String, List<ProductBO>> map = getAllProductsCategoryWise();
		return map.get(categoryName);
	}

	public List<ProductBO> getAllProducts() throws SQLException {
		Connection conn = BaseDAO.getConnection();
		Statement stmt = (Statement) conn.createStatement();
		List<ProductBO> products = new ArrayList<ProductBO>();
		ResultSet rs = stmt.executeQuery(
				"select product_id, product_name, p.category_id, category_name, stock, expiration_date, price from product p "
						+ "inner join category c on c.category_id = p.category_id ");
		while (rs.next()) {
			CategoryBO c = new CategoryBO(rs.getLong(3), rs.getString(4));
			ProductBO p = new ProductBO(rs.getLong(1), rs.getString(2), rs.getDouble(7), "Aisle1", rs.getLong(5),
					rs.getDate(6), c);
			products.add(p);
		}
		return products;
	}

	public Map<String, List<ProductBO>> getAllProductsCategoryWise() throws SQLException {

		Connection conn = BaseDAO.getConnection();
		Statement stmt = (Statement) conn.createStatement();
		Map<String, List<ProductBO>> productsMap = new HashMap<String, List<ProductBO>>();
		ResultSet rs = stmt.executeQuery(
				"select product_id, product_name, p.category_id, category_name, stock, expiration_date, price from product p "
						+ "inner join category c on c.category_id = p.category_id ");
		while (rs.next()) {
			CategoryBO c = new CategoryBO(rs.getLong(3), rs.getString(4));
			ProductBO p = new ProductBO(rs.getLong(1), rs.getString(2), rs.getDouble(7), "Aisle1", rs.getLong(5),
					rs.getDate(6), c);
			if (productsMap.containsKey(c.getCategoryName())) {
				productsMap.get(c.getCategoryName()).add(p);
			} else {
				List<ProductBO> products = new ArrayList<ProductBO>();
				products.add(p);
				productsMap.put(c.getCategoryName(), products);
			}
		}
		return productsMap;

	}

	public int setproductPrice(Long productId, Double productPrice) throws SQLException {
		Connection conn = BaseDAO.getConnection();
		String query = "update product set price = ? where product_id = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		ps.setLong(2, productId);
		ps.setDouble(1, productPrice);
		return ps.executeUpdate();
	}

	public int insertCategory(CategoryBO category) throws Exception {
		Connection conn = BaseDAO.getConnection();
		Statement stmt = (Statement) conn.createStatement();

		String query = "select category_name from category where category_id = ? or category_name = ?";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		ps.setLong(1, category.getCategoryId());
		ps.setString(2, category.getCategoryName());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return 0;
		} else {
			return insertCategory(category, stmt);
		}
	}

	public List<String> getAllCategories() {
		List<String> categoryNames = new ArrayList<String>();
		Connection conn = BaseDAO.getConnection();
		try {
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("select category_name from category");
			while (rs.next()) {
				categoryNames.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println("Error occurred in getAllCategories");
		}

		return categoryNames;

	}

	public boolean checkCategory(Long categoryId) {
		Connection conn = BaseDAO.getConnection();
		try {
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("select category_name from category where category_id = " + categoryId);
			return rs.next();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkProduct(Long productId) {
		Connection conn = BaseDAO.getConnection();
		try {
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("select product_name from product where product_id = " + productId);
			return rs.next();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean stockFormat(Long productStock) {
		String pattern = "0,1,2,3,4,5,6,7,8,9";
		String num = "";
		try {
			if (Pattern.matches(pattern, num)) {
				System.out.println("Enter a VALID number format");
			} else {
				System.out.println("Enter a INVALID number format");
			}
		} catch (NumberFormatException e) {
			// invalid Integer
		}
		return false;
	}

	public boolean priceFormat(Double productPrice) {
		String pattern = "0,1,2,3,4,5,6,7,8,9";
		String num = "";
		try {
			if (Pattern.matches(pattern, num)) {
				System.out.println("Enter a VALID number format");
			} else {
				System.out.println("Enter a INVALID number format");
			}
		} catch (NumberFormatException e) {
			// invalid Integer
		}
		return false;	
	}
}