package com.anaadih.aclassdeal.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anaadih.aclassdeal.Model.WishlistModel;
import com.anaadih.aclassdeal.Repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository wishlistRepository;
	
	@Autowired
	private productService productService;
	
	@Override
	public HashMap<String, Object> addWishlist(String prodId, String userId) {
		HashMap<String, Object> map = new HashMap<>();
		WishlistModel wishlist = new WishlistModel();
		WishlistModel previousAdded=wishlistRepository.findByUserIdAndProdIdProdId(userId,Integer.parseInt(prodId));
		if(previousAdded!=null) {
			map.put("msg", "Already Added to wishlist");
			map.put("type", "Warning!");
			return map;
		}
		wishlist.setProdId(productService.getProductById(Integer.parseInt(prodId)));
		wishlist.setUserId(userId);
		
		wishlist.setStatus(true);
		 wishlistRepository.save(wishlist);
		 map.put("msg", "Product Added to wishlist");
		 map.put("type", "Success");
		 return map;
		 
	}

	@Override
	public List<WishlistModel> getallWishlist(String userId) {
		return wishlistRepository.findByUserId(userId);
	}

}