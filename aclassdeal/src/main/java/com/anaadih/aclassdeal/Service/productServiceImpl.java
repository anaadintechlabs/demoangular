package com.anaadih.aclassdeal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.anaadih.aclassdeal.Model.CategoryModel;
import com.anaadih.aclassdeal.Model.ProductModel;
import com.anaadih.aclassdeal.Repository.ProductRepository;


@Service
public class productServiceImpl implements productService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductModel saveProduct(ProductModel product) {
		 return productRepository.save(product);
	}

	@Override
	public List<ProductModel> getAllProducts(int limit, int offset) {
		Page<ProductModel> page = productRepository.findAll(new PageRequest(offset, limit, new Sort(Direction.ASC,"modifiedDate")));
		return page.getContent();
	}

	@Override
	public ProductModel getProductById(int prodId) {
		Optional<ProductModel> model =  productRepository.findById(prodId);
			return model.get();
		 
	}
	
	@Override
	public List<ProductModel> getAllPendingProducts(int limit, int offset) {
		return productRepository.findByStatus("New");
	}

	@Override
	public void approveProduct(List<String> ids) {
		productRepository.approveProduct(ids);
	}

}
