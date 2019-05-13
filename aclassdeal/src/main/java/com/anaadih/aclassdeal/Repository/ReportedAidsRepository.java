package com.anaadih.aclassdeal.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.anaadih.aclassdeal.Model.AttributeModel;
import com.anaadih.aclassdeal.Model.ReportedAdsModel;

public interface ReportedAidsRepository extends PagingAndSortingRepository<ReportedAdsModel, Long>{

	ReportedAdsModel findByProdID(String reportedId);

	
}
