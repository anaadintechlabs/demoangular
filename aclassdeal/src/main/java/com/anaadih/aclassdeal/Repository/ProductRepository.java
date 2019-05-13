package com.anaadih.aclassdeal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Model.ProductModel;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductModel,Long>{

	List<ProductModel> findByStatus(String status);

	@Query("update ProductModel set status='APPROVED' where prodID in(?1)")
	void approveProduct(List<String> ids);
}
