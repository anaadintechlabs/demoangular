package com.anaadih.aclassdeal.Repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Model.WishlistModel;

public interface WishlistRepository extends PagingAndSortingRepository<CategoryModel,String> {

	WishlistModel save(WishlistModel wishlist);

	List<WishlistModel> findByUserId(String userId);

}
