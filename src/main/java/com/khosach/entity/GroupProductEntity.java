/*
 * @author THUAN-PHAN
 * @date May 15, 2020
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="groupproduct")
public class GroupProductEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="groupproductid")
	private Long groupProductID;
	
	@Column(name="groupproductname",columnDefinition="nvarchar(200)")
	private String groupProductName;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private CategoryEntity category;
	
	@OneToMany(mappedBy="groupProductEntity",fetch=FetchType.LAZY)
	private List<ProductEntity> products;

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

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

	public CategoryEntity getCategory() {
		return category;
	}

	
}
