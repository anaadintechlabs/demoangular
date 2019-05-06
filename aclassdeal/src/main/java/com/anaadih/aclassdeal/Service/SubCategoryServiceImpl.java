package com.anaadih.aclassdeal.Service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Model.SubCategoryModel;
import com.anaadih.aclassdeal.Repository.SubCategoryRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	
	@Override
	public SubCategoryModel saveSubCategory(@Valid SubCategoryModel subCategory) {
		if(subCategoryRepository.existsById(subCategory.getCatCode())) {
			System.out.println("Duplicate Record");
		}
		else {
			subCategoryRepository.save(subCategory);
		}
		//it iwill be changed
		return new SubCategoryModel();
	}


	@Override
	public List<SubCategoryModel> getAllSubCategoryOfCategory(int limit, int offset, String catCode) {
		List<SubCategoryModel> subCategoryList=new ArrayList<>();
		//pagination will be applied later here
		subCategoryList=subCategoryRepository.findByParentCategoryCatCode(catCode);
		
		return subCategoryList;
		
	}

}
