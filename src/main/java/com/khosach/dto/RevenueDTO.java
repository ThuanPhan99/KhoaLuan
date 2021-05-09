/*
 * @author THUAN-PHAN
 * @date Jun 1, 2020
 * @version 1.0
 */

package com.khosach.dto;

public class RevenueDTO {
	private Long totalPrice;
	private Integer year;
	public RevenueDTO(Long totalPrice, Integer year) {
		super();
		this.totalPrice = totalPrice;
		this.year = year;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

	

}
