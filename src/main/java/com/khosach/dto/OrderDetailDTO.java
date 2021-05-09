/*
 * @author THUAN-PHAN
 * @date May 15, 2020
 * @version 1.0
 */

package com.khosach.dto;
@SuppressWarnings("unused")
public class OrderDetailDTO {
	private Long orderDetailID;
	private Long quantity;
	private Long price;
	private Long productID;
	private Integer status;
	private String productName;
	private String thumbnail;
	private Long orderID;
	private Long totally;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getTotally() {
		return this.price * this.quantity;
	}

	public void setTotally(Long totally) {
		this.totally = totally;
	}

	public Long getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(Long orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	public String getstatusString() {
		if(status==0) {
			return "Đã hủy đơn";
		}
		return "Bình thường";
	}

}
