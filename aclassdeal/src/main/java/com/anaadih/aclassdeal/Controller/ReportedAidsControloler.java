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
import com.anaadih.aclassdeal.Model.ProductModel;
import com.anaadih.aclassdeal.Model.ReportedAdsModel;
import com.anaadih.aclassdeal.Service.ReportedAidService;
import com.anaadih.aclassdeal.Service.productService;
import com.anaadih.aclassdeal.util.CommonResponseSender;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ReportedAidsControloler {
	
	@Autowired 
	private ReportedAidService reportedService;
	
	@Autowired 
	private productService productService;
	
	/**
	 * method for user to report particular add
	 * @param rAds
	 * @param errors
	 * @param request
	 * @param response
	 * @return
	 */
	
	/**
	 * method to report ads
	 * @param rAds
	 * @param errors
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/addReportedAids",method=RequestMethod.POST)
	public Map<String,Object> addReportedAids(@RequestBody @Valid ReportedAdsModel rAds,Errors errors,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Inside Reported Aids");
		final HashMap<String, Object> map = new HashMap<>();
		if(errors.hasErrors())
		{
			return (Map<String, Object>) map.put("error", "Something went wrong");
		}
		map.put("Adds", reportedService.saveAdds(rAds));
		return CommonResponseSender.createdSuccessResponse(map, response);
	}
	
	/**
	 * method for admin to block add
	 * @param reportedId
	 * @param errors
	 * @param request
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value="/blockAdd",method=RequestMethod.POST)
	public Map<String,Object> blockAdd(@RequestParam(value="reportedId")String reportedId,Errors errors,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Inside Reported Aids");
		final HashMap<String, Object> map = new HashMap<>();
		if(errors.hasErrors())
		{
			return (Map<String, Object>) map.put("error", "Something went wrong");
		}
		ReportedAdsModel model = reportedService.blockAdds(Integer.parseInt(reportedId));
		map.put("Adds", model);
		ProductModel product = productService.getProductById(model.getProdId().getProdId());
		product.setReported(true);
		product.setInUse(false);
		productService.saveProduct(product);
		return CommonResponseSender.createdSuccessResponse(map, response);
	}
	
	/**
	 * method to get all reported adds
	 * @param limit
	 * @param offset
	 * @param errors
	 * @param request
	 * @param response
	 * @return
	 */
	
	
	@RequestMapping(value="/getallAds",method=RequestMethod.POST)
	public Map<String,Object> getallAds(@RequestParam(value="limit")int limit,
			@RequestParam(value="offset")int offset,Errors errors,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Inside Reported Aids");
		final HashMap<String, Object> map = new HashMap<>();
		if(errors.hasErrors())
		{
			return (Map<String, Object>) map.put("error", "Something went wrong");
		}
		map.put("Adds", reportedService.getallAds(limit,offset));
		return CommonResponseSender.createdSuccessResponse(map, response);
	}

}