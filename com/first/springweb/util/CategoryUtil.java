package com.first.springweb.util;

import org.apache.commons.lang3.StringUtils;

import com.first.springweb.obj.Category;
import com.first.springweb.obj.CategoryBO;

public class CategoryUtil {

	
	public static CategoryBO covertToCategoryBO(Category category){
		
		
		CategoryBO bo = new CategoryBO();
		if(StringUtils.isNotBlank(category.getCategoryId())){
			Long catId =  Long.valueOf(category.getCategoryId());
			bo.setCategoryId(catId);
		}
		bo.setCategoryName(category.getCategoryName());
		
		return bo;
		
	}
}
