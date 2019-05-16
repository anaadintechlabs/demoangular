package com.anaadih.aclassdeal.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Service.WishlistService;
import com.anaadih.aclassdeal.util.CommonResponseSender;

/**
 * 
 * @author Paras
 *
 */


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class WishlistController {

	@Autowired
    private	WishlistService wislistService;
	
	/**
	 * method in which user add products to his wishlist it needs below parameters Pass Prodid as a parameter
	 * @param prodId
	 * @param userId
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value="/addtoWishlist",method=RequestMethod.POST)
	public Map<String,Object> addtoWishlist(@RequestParam (value="prodId") String prodId,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Inside add wishlist");
		final HashMap<String, Object> map = new HashMap<>();
        
		String userId = "";   // By session  for temporary u can do it with parameter
		map.put("wishlist", wislistService.addWishlist(prodId,userId));
		return CommonResponseSender.createdSuccessResponse(map, response);
		
	}
	
	/**
	 * this method is used to get all wishlist wrt user id  Pass user id and get all wishlist 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getallWishlist",method=RequestMethod.POST)
	public Map<String,Object> getallWishlist(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Inside get wishlist");
		final HashMap<String, Object> map = new HashMap<>();

		String userId = "";   // By session  for temporary u can do it with parameter
		map.put("wishlist", wislistService.getallWishlist(userId));
		return CommonResponseSender.createdSuccessResponse(map, response);
		
	}
}
