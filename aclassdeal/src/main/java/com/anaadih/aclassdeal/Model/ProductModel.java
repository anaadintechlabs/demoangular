package com.anaadih.aclassdeal.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Paras
 *
 */

@Entity
public class ProductModel {
		@Id
		private long prodID;
		
		@NotBlank
		private String  prodName;
		
		@NotBlank
		private String prodDesc;
		
		@NotBlank
		private boolean status;
		
		private boolean isInUse;
		
		private boolean isReported;

		private Date createdDate;
		
		private Date modifiedDate;
		
		private String phoneNumber;
		
		private String city;
		
		private String userId;

		private String imgNames;
		
		private long bidId;
		
		private String bidTime;
		
		private String bidamount;
		
		private boolean isBid;
		
		
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

		public long getProdID() {
			return prodID;
		}

		public void setProdID(long prodID) {
			this.prodID = prodID;
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

		public boolean getStatus() {
			return status;
		}

		public void setStatus(boolean status) {
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

		@PrePersist
		public void create() {
			this.setCreatedDate(new Date());
			this.setModifiedDate(new Date());	
		}

		@PreUpdate
		public void update() {
			this.setModifiedDate(new Date());	
		}

}
