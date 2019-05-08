package com.anaadih.aclassdeal.Service;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.anaadih.aclassdeal.Model.ProductattributeMapping;
import com.anaadih.aclassdeal.Repository.ProductAttributeRepository;

public class ProductAttributeServiceImpl implements ProductAttributeService {

	@Autowired
	private ProductAttributeRepository productAttributeRepository;
	@Override
	public Object saveMapping(long prodId, @Valid HashMap<String, String> mappings,String userId) {
		for(String mapping: mappings.keySet()) {
			ProductattributeMapping model  = new ProductattributeMapping();
			model.setAttributeId(Long.parseLong(mapping));
			model.setAttributeValue(mappings.get(mapping));
			model.setProdId(prodId);
			model.setUserId(userId);
			productAttributeRepository.save(model);
		}
		return null;
	}
	@Override
	public List<ProductattributeMapping> getMapping(String prodId, String userId) {
		return productAttributeRepository.findByProdidAndUserid(prodId,userId);
		 
	}

}
