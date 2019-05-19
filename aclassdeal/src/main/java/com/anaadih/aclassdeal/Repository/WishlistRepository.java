package com.anaadih.aclassdeal.Repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.anaadih.aclassdeal.Model.WishlistModel;

public interface WishlistRepository extends PagingAndSortingRepository<WishlistModel,Integer> {

	WishlistModel save(WishlistModel wishlist);

	List<WishlistModel> findByUserId(String userId);

	WishlistModel findByUserIdAndProdIdProdId(String userId, int prodId);

}