package com.anaadih.aclassdeal.Service;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import com.anaadih.aclassdeal.Model.ProductattributeMapping;

public interface ProductAttributeService {

	Object saveMapping(long prodId, @Valid HashMap<String, String> mappings,String userId);

 List<ProductattributeMapping> getMapping(String prodId, String userId);

}
