package com.anaadih.aclassdeal.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.anaadih.aclassdeal.Model.SubCategoryModel;

@Service
public interface SubCategoryService {

	SubCategoryModel saveSubCategory(@Valid SubCategoryModel subCategory);

	List<SubCategoryModel> getAllSubCategoryOfCategory(int limit, int offset, String catCode);

}
