package com.anaadih.aclassdeal.Repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.anaadih.aclassdeal.Model.CategoryModel;

public interface CategoryRepository  extends PagingAndSortingRepository<CategoryModel, Long>
{

	CategoryModel findByCatCode(String getcatCode);

}
