package com.anaadih.aclassdeal.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class CategoryModel {

	@Id
	private String catCode;
	
	@NotBlank
	private String  catName;
	
	@NotBlank
	private String catDesc;
	
	
	private String status;
	
	private boolean isInUse;
	
	private boolean allowBidding;
	
	private int minimumAmount;
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	private String remarks;
	
	@PrePersist
	public void create() {
		this.setCreatedDate(new Date());
		this.setModifiedDate(new Date());	
		this.setStatus("ACTIVE");
	}

	@PreUpdate
	public void update() {
		this.setModifiedDate(new Date());	
	}

	
	
	
	public int getMinimumAmount() {
		return minimumAmount;
	}

	public void setMinimumAmount(int minimumAmount) {
		this.minimumAmount = minimumAmount;
	}

	public boolean isAllowBidding() {
		return allowBidding;
	}

	public void setAllowBidding(boolean allowBidding) {
		this.allowBidding = allowBidding;
	}

	public String getCatCode() {
		return catCode;
	}

	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isInUse() {
		return isInUse;
	}

	public void setInUse(boolean isInUse) {
		this.isInUse = isInUse;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
