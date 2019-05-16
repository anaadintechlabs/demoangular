package com.anaadih.aclassdeal.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Model.ProductModel;
import com.anaadih.aclassdeal.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private productService productService;
	
	@Override
	public CategoryModel saveCategory(CategoryModel category) {
		if(categoryRepository.existsById(category.getCatCode())) {
			System.out.println("Duplicate Record");  
		}
		else {
			categoryRepository.save(category);
		}
		//it iwill be changed
		return new CategoryModel();
	}
	
	
	@Override
	public List<CategoryModel> getAllCategories(int limit, int offset) {
		Page<CategoryModel> page=categoryRepository.findAll(new PageRequest(offset, limit, new Sort(Direction.ASC,"modifiedDate")));
		System.out.println(page.getNumber());
		return page.getContent();
	}


	@Override
	public HashMap<String,Object> getAllCategorywithCount(int limit, int offset) {
		HashMap<String,Object> map = new HashMap();
		List<CategoryModel> catCount = categoryRepository.findByjoinQuery();
		List<CategoryModel> allcategories = (List<CategoryModel>) categoryRepository.findAll();
		map.put("allCategories", allcategories);
		map.put("catCount", catCount);
		return map;
	}
	
}
