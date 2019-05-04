package com.anaadih.aclassdeal.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository; 
	
	@Override
	public void saveOrUpdateCategory(CategoryModel categoryModel) {
		categoryModel.setcatCode(categoryModel.getcatCode().toUpperCase());
		CategoryModel duplicate=categoryRepository.findByCatCode(categoryModel.getcatCode());
				if(duplicate!=null){
			//here update logic
			System.out.println("Duplicate record");
		}
		else {
			
			categoryRepository.save(categoryModel);
			System.out.println("categort saved");
		}
	
	}

	@Override
	public List<CategoryModel> getAllCategories(int limit, int offset) {
		List<CategoryModel> categoryList= new ArrayList<>();
		Page<CategoryModel> page= categoryRepository.findAll(new PageRequest(offset, limit, new Sort(Direction.ASC,"modifiedDate")));
		if(page.getNumber()>0) {
			categoryList=page.getContent();
		}
		return categoryList;
	}

	@Override
	public void delete(CategoryModel category) {
		if(category != null) {
		  categoryRepository.delete(category);	
		}
	}

	@Override
	public CategoryModel getCategoryById(String categoryCode) {
		
		return categoryRepository.findByCatCode(categoryCode);
	}

}
