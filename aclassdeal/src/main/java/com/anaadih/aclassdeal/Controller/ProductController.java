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

import com.anaadih.aclassdeal.FileUploader;
import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Model.ProductModel;
import com.anaadih.aclassdeal.Service.ProductAttributeService;
import com.anaadih.aclassdeal.Service.productService;
import com.anaadih.aclassdeal.util.CommonResponseSender;

/**
 * 
 * @author Paras
 *
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ProductController {
	
	@Autowired
	private productService productService;
	
	@Autowired
	private ProductAttributeService productAttributeService;
	
	@Autowired
	private FileUploader fileUploder;
	
	
	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public Map<String,Object> saveProduct(@RequestBody @Valid ProductModel product,HashMap<String ,String> images,HashMap<String ,String> mappings,Errors errors,HttpServletRequest request,HttpServletResponse response)
	{
		final HashMap<String, Object> map = new HashMap<>();
		if(errors.hasErrors())
		{
			return (Map<String, Object>) map.put("error", "Something went wrong");
		}

		String imgNames = "";
		for(String imgName :images.keySet()) {
			String FPath = fileUploder.getFilePath(imgName,  product.getUserId());
			imgNames += FPath +",";
			fileUploder.uploadFile(images.get(imgName), FPath, imgName, product.getUserId());
		}
		map.put("product", productService.saveProduct(product));
		productAttributeService.saveMapping(product.getProdID(), mappings, product.getUserId());
		return CommonResponseSender.createdSuccessResponse(map, response);
		
	}
	
	@RequestMapping(value="/getAllProducts",method=RequestMethod.GET)
	public Map<String,Object> getAllProducts(@RequestParam(value="limit")int limit,
			@RequestParam(value="offset")int offset,
			HttpServletRequest request,HttpServletResponse response){
		System.out.println("Get all Products");
		final HashMap<String, Object> map = new HashMap<>();
		map.put("categoryList", productService.getAllProducts(limit,offset));
		return CommonResponseSender.createdSuccessResponse(map, response);
	}
	
	@RequestMapping(value="/getProductById",method=RequestMethod.GET)
	public Map<String,Object> getProductById(@RequestParam(value="prodId")String prodId,HttpServletRequest request,HttpServletResponse response){
		System.out.println("Get Product By id");
		final HashMap<String, Object> map = new HashMap<>();
		map.put("categoryList", productService.getProductById(Long.parseLong(prodId)));
		return CommonResponseSender.createdSuccessResponse(map, response);
	}
	

}
