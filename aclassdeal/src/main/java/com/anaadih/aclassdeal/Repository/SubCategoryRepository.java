package com.anaadih.aclassdeal.Repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.anaadih.aclassdeal.Model.SubCategoryModel;

@Repository
public interface SubCategoryRepository  extends PagingAndSortingRepository<SubCategoryModel, String>{

	List<SubCategoryModel> findByParentCategoryCatCode(String catCode);

}
