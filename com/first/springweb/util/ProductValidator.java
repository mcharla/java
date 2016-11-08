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
		if(StringUtils.isBlank(product.getProductName())) {
			arg1.rejectValue("productName", "product.name.required");
	    }	
		
		if(StringUtils.isBlank(product.getProductId())) {
			arg1.rejectValue("productId", "product.id.required");
	    } else{
	    	try{
	    		Long prodID = new Long(product.getProductId());
	    	} catch(Exception e){
	    		arg1.rejectValue("productId", "product.id.invalid");
	    	}
	    }
		
	}

	
}