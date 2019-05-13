package com.anaadih.aclassdeal.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Model.ProductModel;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductModel,Long>{

}
