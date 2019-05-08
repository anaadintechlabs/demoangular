package com.anaadih.aclassdeal.Service;

import java.util.List;

import javax.validation.Valid;

import com.anaadih.aclassdeal.Model.ReportedAdsModel;

public interface ReportedAidService {

	ReportedAdsModel saveAdds(@Valid ReportedAdsModel rAds);

	ReportedAdsModel blockAdds(Long i);

	List<ReportedAdsModel> getallAds(int limit,int offset);
}
