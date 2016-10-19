package com.first.springweb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

import com.first.springweb.obj.CategoryBO;
import com.first.springweb.obj.Product;
import com.first.springweb.obj.ProductBO;

public class ProductUtil {

	public static ProductBO covertToProductBO(Product product) throws ParseException {
		ProductBO bo = new ProductBO();
		bo.setProductPrice(new Double(product.getProductPrice()));
		bo.setProductId(new Long(product.getProductId()));
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		if(StringUtils.isNotBlank(product.getExpiration())){
			bo.setExpiration(sdf.parse(product.getExpiration()));
		}

		bo.setProductName(product.getProductName());
		bo.setProductLocation(product.getProductLocation());
		bo.setProductStock(new Long(product.getProductStock()).longValue());

		CategoryBO categoryBO = CategoryUtil.covertToCategoryBO(product.getCategory());
		bo.setCategory(categoryBO);
		
		return bo;
		
		
	}

}
