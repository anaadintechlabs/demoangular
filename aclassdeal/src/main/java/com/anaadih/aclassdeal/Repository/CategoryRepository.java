package com.anaadih.aclassdeal.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.anaadih.aclassdeal.Model.CategoryModel;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<CategoryModel,String> {

}
