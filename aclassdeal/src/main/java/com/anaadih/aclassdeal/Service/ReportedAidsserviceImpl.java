package com.anaadih.aclassdeal.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.anaadih.aclassdeal.Model.ProductModel;
import com.anaadih.aclassdeal.Model.ReportedAdsModel;
import com.anaadih.aclassdeal.Repository.ReportedAidsRepository;

@Service
public class ReportedAidsserviceImpl implements ReportedAidService {

	@Autowired 
	private ReportedAidsRepository reportedAids;
	@Override
	public ReportedAdsModel saveAdds(@Valid ReportedAdsModel rAds) {
		return reportedAids.save(rAds);
	}
	@Override
	public ReportedAdsModel blockAdds(Long reportedId) {
		ReportedAdsModel model = null;
		Optional<ReportedAdsModel> obj=reportedAids.findById(reportedId);
		if(obj.isPresent()) {
			 model = obj.get();
			model.setStatus(false);
			reportedAids.save(model);
		}
				
		return model;
	}
	@Override
	public List<ReportedAdsModel> getallAds(int limit,int offset) {
		Page<ReportedAdsModel> page = reportedAids.findAll(new PageRequest(offset, limit, new Sort(Direction.ASC,"modifiedDate")));
		return page.getContent();
	}

}
