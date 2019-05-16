package com.anaadih.aclassdeal.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Model.ProductModel;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductModel,Integer>{

	@Transactional
	@Modifying
	@Query("update ProductModel set status='APPROVED' where prodId in(?1)")
	void approveProduct(List<Integer> ids);

	Page<ProductModel> findByStatus(String status, Pageable pg);

	ProductModel findProductsWithCatCode(String catCode);

}
