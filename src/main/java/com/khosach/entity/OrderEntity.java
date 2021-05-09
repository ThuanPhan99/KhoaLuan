/*
 * @author THUAN-PHAN
 * @date May 15, 2020
 * @version 1.0
 */

package com.khosach.entity;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderid")
	private Long orderID;

	@Column(name = "status")
	private Integer status;

	@Column(name = "dateofissue")
	@CreatedDate
	private Date dateOfIssue;
	
	@Column(name = "deliverydate")
	private Date deliveryDate;

	@Column(name = "paymentmethods")
	private Integer paymentMethods;

	@ManyToOne
	@JoinColumn(name = "userid")
	private UserEntity users;

	@OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
	private Collection<OrderDetailEntity> orderDetails;

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Integer getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(Integer paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	public Collection<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
