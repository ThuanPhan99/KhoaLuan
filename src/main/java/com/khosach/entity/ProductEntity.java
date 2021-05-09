/*
 * @author THUAN-PHAN
 * @date May 15, 2020
 * @version 1.0
 */

package com.khosach.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.CollectionUtils;

@Entity
@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	private Long productID;

	@Column(name = "productname", columnDefinition = "nvarchar(255)")
	private String productName;

	@Column(name = "yearofpublication")
	private Integer yearOfPublication;

	@Column(columnDefinition = "nvarchar(255)")
	private String thumbnail;

	@Column(name = "description", columnDefinition = "text")
	private String description;

	@Column(name = "numberofpages")
	private Integer numberOfPages;

	@Column(name = "status")
	private Integer status;

	@Column(name = "isdelete")
	private Integer isDelete;

	@ManyToOne
	@JoinColumn(name = "groupproductid")
	private GroupProductEntity groupProductEntity;

	@OneToMany(mappedBy = "products", fetch = FetchType.LAZY)
	private List<OrderDetailEntity> orderDetails;

	@OneToMany(mappedBy = "products")
	private List<CartEntity> carts;

	@OneToOne(mappedBy="product",fetch=FetchType.LAZY)
	private ProductSaleEntity productSale;

	@OneToOne(mappedBy="product",fetch=FetchType.LAZY)
	private ProductPriceEntity productPrice;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name = "publisherid")
	private PublishersEntity publishersEntity;

	@NotFound(action = NotFoundAction.IGNORE)
	@OneToOne(mappedBy="product",fetch=FetchType.LAZY)
	private ProductAddEntity productAddEntity;

	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name = "productgenreid")
	private ProductGenreEntity productGenreEntity;

	@NotFound(action = NotFoundAction.IGNORE)
	@OneToMany(mappedBy = "products", fetch = FetchType.LAZY)
	private List<ProductAuthorEntity> productAuthorEntities;

	public Long getQuantity (){
		Long quantity = 0L;
		if(Objects.nonNull(productAddEntity)){
			quantity = productAddEntity.getQuantity() - getNumOfOrder();
		}
		return quantity;

	}

	public Long getNumOfOrder(){
		Long count = 0L;
		if(!CollectionUtils.isEmpty(orderDetails)){
			for (OrderDetailEntity orderDetailEntity : orderDetails ){
				if(orderDetailEntity.getStatus() !=0 ){
					count = count + orderDetailEntity.getQuantity();
				}
			}
		}
		return count;
	}

	public ProductGenreEntity getProductGenreEntity() {
		return productGenreEntity;
	}

	public void setProductGenreEntity(ProductGenreEntity productGenreEntity) {
		this.productGenreEntity = productGenreEntity;
	}

	public List<ProductAuthorEntity> getProductAuthorEntities() {
		return productAuthorEntities;
	}

	public void setProductAuthorEntities(List<ProductAuthorEntity> productAuthorEntities) {
		this.productAuthorEntities = productAuthorEntities;
	}

	public ProductAddEntity getProductAddEntity() {
		return productAddEntity;
	}

	public void setProductAddEntity(ProductAddEntity productAddEntity) {
		this.productAddEntity = productAddEntity;
	}

	public PublishersEntity getPublishersEntity() {
		return publishersEntity;
	}

	public void setPublishersEntity(PublishersEntity publishersEntity) {
		this.publishersEntity = publishersEntity;
	}

	public ProductPriceEntity getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(ProductPriceEntity productPrice) {
		this.productPrice = productPrice;
	}

	public ProductSaleEntity getProductSale() {
		return productSale;
	}

	public void setProductSale(ProductSaleEntity productSale) {
		this.productSale = productSale;
	}

	public List<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public List<CartEntity> getCarts() {
		return carts;
	}

	public void setCarts(List<CartEntity> carts) {
		this.carts = carts;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public GroupProductEntity getGroupProductEntity() {
		return groupProductEntity;
	}

	public void setGroupProductEntity(GroupProductEntity groupProductEntity) {
		this.groupProductEntity = groupProductEntity;
	}

}
