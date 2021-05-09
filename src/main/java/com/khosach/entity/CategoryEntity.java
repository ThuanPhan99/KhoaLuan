/*
 * @author THUAN-PHAN
 * @date May 14, 2020
 * @version 1.0
 */

package com.khosach.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="categoryid")
	private Long categoryID;
	
	@Column(name="categoryname",columnDefinition="nvarchar(200)")
	private String categoryName;
	
	@Column
	private String picture;
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@OneToMany(mappedBy="category",fetch=FetchType.LAZY)
	private List<GroupProductEntity> groupProductEntity;

	public List<GroupProductEntity> getGroupProductEntity() {
		return groupProductEntity;
	}

	public void setGroupProductEntity(List<GroupProductEntity> groupProductEntity) {
		this.groupProductEntity = groupProductEntity;
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
