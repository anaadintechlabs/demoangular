package com.anaadih.aclassdeal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	//USER WILL ONLY ABLE TO SEE APPROVED PRODUCTS
	@Override
	public List<ProductModel> getAllProducts(int limit, int offset) {
		//Sending Pageable Interface instead of PageRequest due to this error
//		At least 2 parameter(s) provided but only 1 parameter(s) present in query.
		Pageable pg=PageRequest.of(offset,limit, new Sort(Direction.ASC,"modifiedDate"));
		Page<ProductModel> page= productRepository.findByStatus("APPROVED",pg);
		return page.getContent();
	}

	@Override
	public ProductModel getProductById(int prodId) {
		Optional<ProductModel> model =  productRepository.findById(prodId);
		if(model.isPresent()) {
			
		
			return model.get();
		}
		return null;
	}
	
	@Override
	public List<ProductModel> getAllPendingProducts(int limit, int offset) {
		//Sending Pageable Interface instead of PageRequest due to this error
//		At least 2 parameter(s) provided but only 1 parameter(s) present in query.
		Pageable pg=PageRequest.of(offset,limit, new Sort(Direction.ASC,"modifiedDate"));
		Page<ProductModel> page= productRepository.findByStatus("New",pg);
		return page.getContent();
	}

	@Override
	public void approveProduct(List<Integer> ids) {
		System.out.println("ID"+ids);
		productRepository.approveProduct(ids);
	}

	@Override
	public ProductModel findProductsWithCatCode(String catCode) {
		productRepository.findProductsWithCatCode(catCode);
		return null;
	}

}
