package com.anaadih.aclassdeal.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Service.CategoryService;
import com.anaadih.aclassdeal.util.CommonResponseSender;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value="/saveCategory",method=RequestMethod.POST)
	public Map<String,Object> saveCategory(@RequestBody @Valid CategoryModel category,Errors errors,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Inside save category");
		final HashMap<String, Object> map = new HashMap<>();
		if(errors.hasErrors())
		{
			return (Map<String, Object>) map.put("error", "Something went wrong");
		}

		map.put("category", categoryService.saveCategory(category));
		return CommonResponseSender.createdSuccessResponse(map, response);
		
	}
	
	
	@RequestMapping(value="/getAllCategories",method=RequestMethod.GET)
	public Map<String,Object> getAllCategories(@RequestParam(value="limit")int limit,
			@RequestParam(value="offset")int offset,
			HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Inside save category");
		final HashMap<String, Object> map = new HashMap<>();

		map.put("categoryList", categoryService.getAllCategories(limit,offset));
		return CommonResponseSender.createdSuccessResponse(map, response);
		
	}
	
	

	
	
	
}
