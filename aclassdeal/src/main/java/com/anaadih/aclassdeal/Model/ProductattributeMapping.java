package com.anaadih.aclassdeal.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Paras
 *
 */
@Entity
public class ProductattributeMapping {

	@Id
	private long sno;
	
	private long prodId;
	
	private long attributeId;
	
	public long getSno() {
		return sno;
	}

	public void setSno(long sno) {
		this.sno = sno;
	}

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(long attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private String attributeValue;
	
	private String userId;
	
}
