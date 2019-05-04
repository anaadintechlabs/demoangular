package com.anaadih.aclassdeal.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anaadih.aclassdeal.Model.CategoryModel;

@Service
public interface CategoryService {

	void saveOrUpdateCategory(CategoryModel categoryModel);

	List<CategoryModel> getAllCategories(int limit, int offet);

	void delete(CategoryModel category);

	CategoryModel getCategoryById(String categoryId);
	
}
