package com.anaadih.aclassdeal.Model;

import java.util.Date;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Paras
 *
 */
//JSon Ignore unknwon property is  used to ignore the propery from converting json to objec
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)

public class ProductModel {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int prodId;
		
		//Ad Title
		@NotBlank
		private String  prodName;
		
		@ManyToOne
		private CategoryModel category;
		
		@ManyToOne SubCategoryModel subCategory;
		
		//Ad Description
		@NotBlank
		private String prodDesc;

		private String phoneNumber;		
		
		private String city;
		
		private String status;
		
		private boolean isInUse;
		
		private boolean isReported;
		
		private boolean isApproved;

		private Date createdDate;
		
		private Date modifiedDate;
		
		private double price;
		
		private String userId;

		private String imgNames;
		
		private String mainImage;
		
		private long bidId;
		
		private String bidTime;
		
		private String bidamount;
		
		private boolean isBid;
		
		private String model;
		
		//Check for allow user to visible/hide number to other user on  positng adds
		private boolean allowNumber;
		
		@Transient
		private HashMap<String, String> attributes;
		

		

		public boolean isAllowNumber() {
			return allowNumber;
		}


		public void setAllowNumber(boolean allowNumber) {
			this.allowNumber = allowNumber;
		}


		public String getMainImage() {
			return mainImage;
		}


		public void setMainImage(String mainImage) {
			this.mainImage = mainImage;
		}


		public boolean isApproved() {
			return isApproved;
		}


		public void setApproved(boolean isApproved) {
			this.isApproved = isApproved;
		}


		public int getProdId() {
			return prodId;
		}


		public void setProdId(int prodId) {
			this.prodId = prodId;
		}


		public String getModel() {
			return model;
		}


		public void setModel(String model) {
			this.model = model;
		}

		 

		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}


		@PrePersist
		public void setValues() {
			this.setUserId("ADMIN");
			this.setStatus("NEW");
			this.setCreatedDate(new Date());
			this.setModifiedDate(new Date());
		}
		
		
		public CategoryModel getCategory() {
			return category;
		}

		public void setCategory(CategoryModel category) {
			this.category = category;
		}

		public SubCategoryModel getSubCategory() {
			return subCategory;
		}

		public void setSubCategory(SubCategoryModel subCategory) {
			this.subCategory = subCategory;
		}

		public long getBidId() {
			return bidId;
		}

		public void setBidId(long bidId) {
			this.bidId = bidId;
		}

		public String getBidTime() {
			return bidTime;
		}

		public void setBidTime(String bidTime) {
			this.bidTime = bidTime;
		}

		public String getBidamount() {
			return bidamount;
		}

		public void setBidamount(String bidamount) {
			this.bidamount = bidamount;
		}

		public boolean isBid() {
			return isBid;
		}

		public void setBid(boolean isBid) {
			this.isBid = isBid;
		}



		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}



		public String getProdName() {
			return prodName;
		}

		public void setProdName(String prodName) {
			this.prodName = prodName;
		}

		public String getProdDesc() {
			return prodDesc;
		}

		public void setProdDesc(String prodDesc) {
			this.prodDesc = prodDesc;
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

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public boolean isReported() {
			return isReported;
		}

		public void setReported(boolean isReported) {
			this.isReported = isReported;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		public String getImgNames() {
			return imgNames;
		}

		public void setImgNames(String imgNames) {
			this.imgNames = imgNames;
		}

	
		@PreUpdate
		public void update() {
			this.setModifiedDate(new Date());	
		}


		public HashMap<String, String> getAttributes() {
			return attributes;
		}


		public void setAttributes(HashMap<String, String> attributes) {
			this.attributes = attributes;
		}


		@Override
		public String toString() {
			return "ProductModel [prodId=" + prodId + ", prodName=" + prodName + ", category=" + category
					+ ", subCategory=" + subCategory + ", prodDesc=" + prodDesc + ", phoneNumber=" + phoneNumber
					+ ", city=" + city + ", status=" + status + ", isInUse=" + isInUse + ", isReported=" + isReported
					+ ", isApproved=" + isApproved + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate
					+ ", price=" + price + ", userId=" + userId + ", imgNames=" + imgNames + ", bidId=" + bidId
					+ ", bidTime=" + bidTime + ", bidamount=" + bidamount + ", isBid=" + isBid + ", model=" + model
					+ ", attributes=" + attributes +  "]";
		}



		
		

}
