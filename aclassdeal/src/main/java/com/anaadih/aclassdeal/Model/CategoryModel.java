package com.anaadih.aclassdeal.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "CATEGORY")
public class CategoryModel {
	
	private static final Logger LOGGER_APP = LoggerFactory.getLogger(CategoryModel.class);

	private static final long serialVersionUID = 946601794784564287L;
	
	@Column(name="CATCODE")
	@NotBlank
	@Size(min=3,max=25)
	private String catCode;
	
	@Column(name="CATNAME")
	@NotBlank
	@Size(min=3,max=25)
	private String catName;
	
	@Column(name="CATDESC")
	@NotBlank
	@Size(min=3,max=25)
	private String catDesc;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="INUSE")
	private String inUse;
	
	private Date createdDate;
	
	private Date modifiedDate;
	
	@PrePersist
	public void addData()
	{
		this.setCreatedDate(new Date());
		this.setModifiedDate(new Date());
	}
	
	@PreUpdate
	private void updateDate() {
		this.setModifiedDate(new Date());
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

	public String getInUse() {
		return inUse;
	}

	public void setInUse(String inUse) {
		this.inUse = inUse;
	}

	public String getcatCode() {
		return catCode;
	}

	public void setcatCode(String catID) {
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
	
}
