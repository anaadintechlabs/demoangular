package com.anaadih.aclassdeal.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	public WishlistModel addWishlist(String prodId, String userId) {
		WishlistModel wishlist = new WishlistModel();
		WishlistModel previousAdded=wishlistRepository.findByUserIdAndProdIdProdId(userId,Integer.parseInt(prodId));
		if(previousAdded!=null) {
			System.out.println("Already Added");
		}
		wishlist.setProdId(productService.getProductById(Integer.parseInt(prodId)));
		wishlist.setUserId("ADMIN1");
		
		wishlist.setStatus(true);
		return wishlistRepository.save(wishlist);
	}

	@Override
	public List<WishlistModel> getallWishlist(String userId) {
		return wishlistRepository.findByUserId(userId);
	}

}