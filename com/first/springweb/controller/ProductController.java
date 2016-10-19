package com.first.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.first.springweb.obj.Product;
import com.first.springweb.obj.ProductBO;
import com.first.springweb.service.WarehouseService;
import com.first.springweb.util.ProductUtil;

@Controller
public class ProductController {

	@Autowired
	WarehouseService wareHouseService;
	
	 @RequestMapping(value = "/product", method = RequestMethod.GET)
	   public String product( Model model) {
		 Product product = new Product();
		 model.addAttribute("product", product);
		 List<String> categorys = wareHouseService.getCategories();
		model.addAttribute("categoryList", categorys);
		 return "product";
	   }
	 
	  @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	   public String addProduct(@ModelAttribute("product")Product product, BindingResult result, Model model) throws Exception {
	
		   ProductBO productBO = ProductUtil.covertToProductBO(product);
		   int noRows = wareHouseService.addProduct(productBO); //layer connectivity
		   if(noRows > 0){
			      model.addAttribute("displayMessage", "Product "+product.getProductName()+" Added Successfully");
		   } else{
			      model.addAttribute("displayMessage", "Error in adding the product: "+product.getProductName());
		   }
	      return "result";
	   }
}
