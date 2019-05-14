package com.anaadih.aclassdeal.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.anaadih.aclassdeal.Model.AttributeModel;
import com.anaadih.aclassdeal.Model.ReportedAdsModel;


@Repository
public interface ReportedAidsRepository extends PagingAndSortingRepository<ReportedAdsModel, Integer>{

	ReportedAdsModel findByProdId(String reportedId);

	Page<ReportedAdsModel> findByStatus(boolean b, PageRequest pageRequest);


	
}
