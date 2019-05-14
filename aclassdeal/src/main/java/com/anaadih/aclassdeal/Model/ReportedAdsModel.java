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
	private int reportedId;
	
	@ManyToOne
	private ProductModel prodId;
	
	@NotBlank
	private String  userId;
	
	@NotBlank
	private String reportDate;
	



	@NotBlank
	private String reportCount;
	
	private boolean status;
	
	private boolean description;


	

	public int getReportedId() {
		return reportedId;
	}

	public void setReportedId(int reportedId) {
		this.reportedId = reportedId;
	}
	
	public boolean isDescription() {
		return description;
	}

	public void setDescription(boolean description) {
		this.description = description;
	}



	public ProductModel getProdId() {
		return prodId;
	}

	public void setProdId(ProductModel prodId) {
		this.prodId = prodId;
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
