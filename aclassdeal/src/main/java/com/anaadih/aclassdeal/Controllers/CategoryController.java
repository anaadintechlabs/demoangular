package com.anaadih.aclassdeal.Controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Services.CategoryService;

@RestController
@RequestMapping("/Category.do")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	private static final org.slf4j.Logger LOGGER =  LoggerFactory.getLogger(CategoryService.class);
	
	
	/**
	 * Paras
	 * @param request
	 * @param response
	 * @param categoryModel
	 * @return
	 */
	@RequestMapping(value="/saveCategory",method = {RequestMethod.POST,RequestMethod.GET})
	private Map<String, Object> saveOrUpdateCategory(HttpServletRequest request, HttpServletResponse response,@RequestBody @Valid
			CategoryModel categoryModel,Errors errors){
		final Map<String,Object> map = new HashMap<>();
		
		if(errors.hasErrors()) {
			map.put("error", "Invalid Data");
			return map;
		}
		categoryService.saveOrUpdateCategory(categoryModel);
		map.put("data", "category added");
		return map;	
	}
	
	
	/**
	 * @author Paras
	 * @param request
	 * @param response
	 * @param limit
	 * @param offet
	 * @return
	 */
	@RequestMapping(value="/getAllCategories",method = {RequestMethod.GET,RequestMethod.POST})
	private Map<String, Object> getAllCategories(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("limit") int limit,@RequestParam("offset") int offet){
		final Map<String,Object> map = new HashMap<>();
		
		map.put("categoryList", categoryService.getAllCategories(limit,offet));
		return createdSuccessResponse(map,response);	
	}
	
	@RequestMapping(value="/deleteCategory",method = {RequestMethod.GET,RequestMethod.POST})
	private Map<String, Object> deleteCategory(HttpServletRequest request, HttpServletResponse response,
			@RequestBody CategoryModel category){
		final Map<String,Object> map = new HashMap<>();
		categoryService.delete(category);
		map.put("data", "Category deleted");
		return createdSuccessResponse(map,response);	
	}
	
   /**
    * 
    * @param request
    * @param response
    * @param categoryId
    * @return
    */
	
	@RequestMapping(value="/getCategoryByCode",method = {RequestMethod.GET,RequestMethod.POST})
	private Map<String, Object> getCategoryById(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("categoryCode") String categoryId){
		final Map<String,Object> map = new HashMap<>();
		map.put("data",categoryService.getCategoryById(categoryId));
		return createdSuccessResponse(map,response);	
	}
	
	
	
	public static Map<String, Object> createdSuccessResponse(Object object, HttpServletResponse response) {
		response.setStatus(HttpStatus.CREATED.value());
		return setResponse(HttpStatus.CREATED.value(), true, "Record successfully created", object);
}
	
	private static Map<String, Object> setResponse(int status, boolean isSuccess, String message, Object object) {
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("status", status);
		responseMap.put("isSuccess", isSuccess);
		responseMap.put("message", message);
		if(isSuccess){
			responseMap.put("data",object);
		}
		else{
			responseMap.put("error",object);
		}
		 return responseMap;
	}
}
	
