package com.anaadih.aclassdeal.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anaadih.aclassdeal.Model.WishlistModel;

@Service
public interface WishlistService {

	WishlistModel addWishlist(String prodId, String userId);

	List<WishlistModel> getallWishlist(String userId);

}
