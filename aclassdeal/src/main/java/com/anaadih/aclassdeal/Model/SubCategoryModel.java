package com.anaadih.aclassdeal.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

@Entity
public class SubCategoryModel {

	@Id
	private String catCode;
	
	@NotBlank
	private String  catName;
	
	@NotBlank
	private String catDesc;
	
	@NotBlank
	private String status;
	
	@ManyToOne
	private CategoryModel parentCategory;
	
	private boolean modelAvailable;
	
	private String models;
	
	private boolean isInUse;
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	private String remarks;
	
	@PrePersist
	public void addDates() {
		this.setCreatedDate(new Date());
		this.setModifiedDate(new Date());
		this.setStatus("ACTIVE");
	}
	@PreUpdate
	public void updateDate() {
		this.setModifiedDate(new Date());
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

	public CategoryModel getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(CategoryModel parentCategory) {
		this.parentCategory = parentCategory;
	}

	public boolean isModelAvailable() {
		return modelAvailable;
	}

	public void setModelAvailable(boolean modelAvailable) {
		this.modelAvailable = modelAvailable;
	}

	public String getModels() {
		return models;
	}

	public void setModels(String models) {
		this.models = models;
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

	@Override
	public String toString() {
		return "SubCategoryModel [catCode=" + catCode + ", catName=" + catName + ", catDesc=" + catDesc + ", status="
				+ status + ", parentCategory=" + parentCategory + ", modelAvailable=" + modelAvailable + ", models="
				+ models + ", isInUse=" + isInUse + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
				+ ", remarks=" + remarks + "]";
	}
	
	
	
	
}
