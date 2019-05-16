package com.anaadih.aclassdeal.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class WishlistModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wishlistId;
	
	@ManyToOne
	@NotBlank
	private ProductModel prodId;
	
	@NotBlank
	@ManyToOne
	private String  userId;
	
	@NotBlank
	private String wishlistDate;
	
	private boolean status;

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
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

	public String getwishlistDate() {
		return wishlistDate;
	}

	public void setwishlistDate(String wishlistDate) {
		this.wishlistDate = wishlistDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
