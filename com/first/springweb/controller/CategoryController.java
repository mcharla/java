package com.first.springweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.first.springweb.obj.Category;
import com.first.springweb.obj.CategoryBO;
import com.first.springweb.service.WarehouseService;
import com.first.springweb.util.CategoryUtil;
import com.first.springweb.util.CategoryValidator;

@Controller
public class CategoryController {
	
	
	@Autowired
	WarehouseService wareHouseService;
	
	 @RequestMapping(value = "/category", method = RequestMethod.GET)
	   public String category(HttpServletRequest request, Model model) {
	   	 //git commit test
		 Category category = new Category();
		 model.addAttribute("category", category);
		 return "category";
	   }
	   
	   @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	   public String addCategory(@ModelAttribute("category")Category category, BindingResult result, Model model) throws Exception {
	
		   CategoryValidator validator = new CategoryValidator();
		   validator.validate(category, result);
		   
		   if (result.hasErrors()){
			   return "category";
		   } else if(wareHouseService.categoryExists(new Long(category.getCategoryId()))){
			   result.rejectValue("categoryId", "category.already.exists");
			   return "category";
		   }
		   //if exists
		   
		   CategoryBO categoryBO = CategoryUtil.covertToCategoryBO(category);
		   
		   int noRows = wareHouseService.addCategory(categoryBO);
		   if(noRows > 0){
			      model.addAttribute("displayMessage", "Category "+category.getCategoryName()+" Added Successfully");
		   } else{
			      model.addAttribute("displayMessage", "Error in adding the category: "+category.getCategoryName());
		   }
		   
	      return "result";
	   }

}
