/*
 * @author THUAN-PHAN
 * @date May 15, 2020
 * @version 1.0
 */

package com.khosach.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderDTO {
	private Long orderID;
	private Integer status;
	private Date dateOfIssue;
	private Date deliveryDate;
	private Integer paymentMethods;
	private Long userid;
	private List<OrderDetailDTO> listOrDerDetail;
	public List<OrderDetailDTO> getListOrDerDetail() {
		return listOrDerDetail;
	}
	public void setListOrDerDetail(List<OrderDetailDTO> listOrDerDetail) {
		this.listOrDerDetail = listOrDerDetail;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
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
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getPaymentMethodsString() {
		if(paymentMethods==1) {
			return "Thanh toán khi nhận hàng";
		}else {
			return "Thanh toán bằng MoMo";
		}
		
	}
	public String getStatusString() {
		if(status==1) {
			return "Chưa duyệt";
		}
		if(status==2) {
			return "Đã duyệt";
		}
		if(status==3) {
			return "Đang giao hàng";
		}
		if(status==4) {
			return "Đã thanh toán";
		}
		if(status==6) {
			return "Đã hoàn thành";
		}
		return "Hủy đơn";
		
		
	}
	public String getDeliveryDateString(){
		SimpleDateFormat day = new SimpleDateFormat("dd-MM-yyyy");
		if(deliveryDate == null)
			return null;
		return day.format(deliveryDate);
	}
	public String getDateOfIssueString(){
		SimpleDateFormat day = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if(dateOfIssue == null)
			return null;
		return day.format(dateOfIssue);
	}
	
}
