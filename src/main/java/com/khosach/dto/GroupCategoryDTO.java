/*
 * @author THUAN-PHAN
 * @date May 10, 2020
 * @version 1.0
 */

package com.khosach.dto;

public class GroupCategoryDTO {
	private String base64;
	private Long groupCategoriesID;
	private String groupCategoriesName;
	private String picture;
	
	
	public String getBase64() {
		return base64.split(",")[1];
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public Long getGroupCategoriesID() {
		return groupCategoriesID;
	}

	public void setGroupCategoriesID(Long groupCategoriesID) {
		this.groupCategoriesID = groupCategoriesID;
	}

	public String getGroupCategoriesName() {
		return groupCategoriesName;
	}

	public void setGroupCategoriesName(String groupCategoriesName) {
		this.groupCategoriesName = groupCategoriesName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
