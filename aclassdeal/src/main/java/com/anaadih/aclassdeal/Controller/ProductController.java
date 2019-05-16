package com.anaadih.aclassdeal.Controller;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;

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
	
	
	/**
	 * method to save product with attributes and images
	 * @param product
	 * @param images
	 * @param mappings
	 * @param errors
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public Map<String,Object> saveProduct(@RequestBody @Valid ProductModel product,Errors errors,HttpServletRequest request,HttpServletResponse response)
	{
		final HashMap<String, Object> map = new HashMap<>();
		if(errors.hasErrors())
		{
			return (Map<String, Object>) map.put("error", "Something went wrong");
		}

		System.out.println("producst issss"+product);
		HashMap<String ,MultipartFile> images=product.getImages();
		String imgNames = "";
		if(images!=null) {
		for(String imgName :images.keySet()) {
			String FPath = fileUploder.getFilePath(imgName,  product.getUserId());
			System.out.println("FPATH"+FPath);
			imgNames += FPath +",";
			fileUploder.uploadFile(images.get(imgName), FPath, imgName, product.getUserId());
		}
		}
		HashMap<String ,String> mappings=product.getAttributes();
		map.put("product", productService.saveProduct(product));
		System.out.println("product saved");
		productAttributeService.saveMapping(product.getProdId(), mappings, product.getUserId());
		return CommonResponseSender.createdSuccessResponse(map, response);
		
	}
	
	/**
	 * method to get product By Id
	 * @param prodId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getAllProducts",method=RequestMethod.GET)
	public Map<String,Object> getAllProducts(@RequestParam(value="limit")int limit,
			@RequestParam(value="offset")int offset,
			HttpServletRequest request,HttpServletResponse response){
		System.out.println("Get all Products");
		final HashMap<String, Object> map = new HashMap<>();
		map.put("productList", productService.getAllProducts(limit,offset));
		return CommonResponseSender.createdSuccessResponse(map, response);
	}
	
	
	/**
	 * method to get product By Id
	 * @param prodId
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value="/getProductById",method=RequestMethod.GET)
	public Map<String,Object> getProductById(@RequestParam(value="prodId")String prodId,HttpServletRequest request,HttpServletResponse response){
		System.out.println("Get Product By id");
		final HashMap<String, Object> map = new HashMap<>();
		map.put("product", productService.getProductById(Integer.parseInt(prodId)));
		return CommonResponseSender.createdSuccessResponse(map, response);
	}
	

	
	/**
	 * all pending products are shown to admin
	 * @param limit
	 * @param offset
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value="/getAllPendingProducts",method=RequestMethod.GET)
	public Map<String,Object> getAllPendingProducts(@RequestParam(value="limit")int limit,
			@RequestParam(value="offset")int offset,
			HttpServletRequest request,HttpServletResponse response){
		System.out.println("Get all Products");
		final HashMap<String, Object> map = new HashMap<>();
		map.put("pendingProductList", productService.getAllPendingProducts(limit,offset));
		return CommonResponseSender.createdSuccessResponse(map, response);
	}
	
	

	/**
	 * dashboard method to get products
	 * @param limit
	 * @param offset
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value="/getAllProductsDashboard",method=RequestMethod.GET)
	public Map<String,Object> getAllProductsDashboard(@RequestParam(value="limit")int limit,
			@RequestParam(value="offset")int offset,
			HttpServletRequest request,HttpServletResponse response){
		System.out.println("Get all Products");
		final HashMap<String, Object> map = new HashMap<>();
		map.put("productList", productService.getAllProducts(limit,offset));
		return CommonResponseSender.createdSuccessResponse(map, response);
	}
	
	/**
	 * method to approve all products by admin
	 * @param limit
	 * @param offset
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value="/approveProduct",method=RequestMethod.GET)
	public Map<String,Object> approveProduct(@RequestParam (value = "Ids") List<Integer> Ids,
			HttpServletRequest request,HttpServletResponse response){
		System.out.println("Approved all Products");
		final HashMap<String, Object> map = new HashMap<>();
		productService.approveProduct(Ids);
		map.put("product", "Approved");
		return CommonResponseSender.createdSuccessResponse(map, response);
	}
	
	
}
