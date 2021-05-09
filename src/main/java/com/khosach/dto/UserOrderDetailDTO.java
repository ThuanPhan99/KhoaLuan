/*
 * @author THUAN-PHAN
 * @date May 28, 2020
 * @version 1.0
 */

package com.khosach.dto;

import java.util.Date;

public class UserOrderDetailDTO {
	private Integer status;
	private Date dateOfIssue;
	private OrderDetailDTO orderDetail;
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
	public OrderDetailDTO getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(OrderDetailDTO orderDetail) {
		this.orderDetail = orderDetail;
	}
}
