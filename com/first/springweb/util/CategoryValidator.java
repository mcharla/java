package com.first.springweb.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.first.springweb.obj.Category;

public class CategoryValidator implements Validator {

	public boolean supports(Class clazz) {
	      return Category.class.equals(clazz);
	}

	public void validate(Object arg0, Errors arg1) {
		Category category = (Category) arg0;
		if(StringUtils.isBlank(category.getCategoryName())) {
			arg1.rejectValue("categoryName", "category.name.required");
	    }	
		
		if(StringUtils.isBlank(category.getCategoryId())) {
			arg1.rejectValue("categoryId", "category.id.required");
	    } else{
	    	try{
	    		Long catID = new Long(category.getCategoryId());
	    	} catch(Exception e){
	    		arg1.rejectValue("categoryId", "category.id.invalid");
	    	}
	    }
		
	}

}
