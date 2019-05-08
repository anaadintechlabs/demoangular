package com.anaadih.aclassdeal.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
/**
 * 
 * @author Paras
 *
 */
@Entity
public class ReportedAdsModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long reportedId;
	
	@ManyToOne
	private ProductModel prodID;
	
	@NotBlank
	private String  userId;
	
	@NotBlank
	private String reportDate;
	


	public long getReportedId() {
		return reportedId;
	}

	public void setReportedId(long reportedId) {
		this.reportedId = reportedId;
	}

	@NotBlank
	private String reportCount;
	
	private boolean status;
	
	private boolean desc;
	
	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	public ProductModel getProdID() {
		return prodID;
	}

	public void setProdID(ProductModel prodID) {
		this.prodID = prodID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportCount() {
		return reportCount;
	}

	public void setReportCount(String reportCount) {
		this.reportCount = reportCount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


}
