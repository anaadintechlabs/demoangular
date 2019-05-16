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
		wishlist.setProdId(productService.getProductById(Long.parseLong(prodId)));
		wishlist.setUserId(userId);
		wishlist.setwishlistDate(new SimpleDateFormat().format(new Date()));
		wishlist.setStatus(true);
		return wishlistRepository.save(wishlist);
	}

	@Override
	public List<WishlistModel> getallWishlist(String userId) {
		return wishlistRepository.findByUserId(userId);
	}

}