package com.anaadih.aclassdeal.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.anaadih.aclassdeal.Model.ProductModel;


@Service
public interface productService {

	ProductModel saveProduct(ProductModel category);

	List<ProductModel> getAllProducts(int limit, int offset);

	ProductModel getProductById(int prodId);
	
	List<ProductModel> getAllPendingProducts(int limit, int offset);


	void approveProduct(List<Integer> ids);

	ProductModel findProductsWithCatCode(String catCode);
}
