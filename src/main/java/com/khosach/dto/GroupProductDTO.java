/*
 * @author THUAN-PHAN
 * @date May 15, 2020
 * @version 1.0
 */

package com.khosach.dto;

public class GroupProductDTO {

	private Long groupProductID;
	private String groupProductName;
	private Long categoryID;
	private String categoryName;

	public Long getGroupProductID() {
		return groupProductID;
	}

	public void setGroupProductID(Long groupProductID) {
		this.groupProductID = groupProductID;
	}

	public String getGroupProductName() {
		return groupProductName;
	}

	public void setGroupProductName(String groupProductName) {
		this.groupProductName = groupProductName;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
