package com.first.springweb.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.first.springweb.obj.Product;

public class ProductValidator implements Validator {

	public boolean supports(Class clazz) {
		return Product.class.equals(clazz);
	}

	public void validate(Object arg0, Errors arg1) {
		Product product = (Product) arg0;
		if (StringUtils.isBlank(product.getProductName())) {
			arg1.rejectValue("productName", "product.name.required");
		}

		if (StringUtils.isBlank(product.getProductId())) {
			arg1.rejectValue("productId", "product.id.required");
		} else {
			try {
				new Long(product.getProductId());
			} catch (Exception e) {
				arg1.rejectValue("productId", "product.id.invalid");
			}
		}
		if (StringUtils.isNotBlank((product.getExpiration()))
				&& !DateUtil.checkIfDateIsValid(product.getExpiration())) {
			arg1.rejectValue("expiration", "product.expiration.format");
		}

		if (StringUtils.isBlank(product.getProductLocation())) {
			arg1.rejectValue("productLocation", "product.Location.required");
		} else {
			try {
				new Long(product.getProductId());
			} catch (Exception e) {
				arg1.rejectValue("productLocation", "product.Location.invalid");
			}

		}

		if (StringUtils.isBlank(product.getProductStock())) {
			arg1.rejectValue("productStock", "product.stock.required");
		} else {
			try {
				new Long(product.getProductStock());
			} catch (Exception e) {
				arg1.rejectValue("productStock", "product.stock.invalid");
			}
		}
		if(StringUtils.isBlank(product.getProductPrice())){
			arg1.rejectValue("productPrice", "product.price.required");
		}else{
			try{
				new Double(product.getProductPrice());
			} catch(Exception e){
				arg1.rejectValue("productPrice", "product.price.invalid");
			}
			
		}
		

	}
}
