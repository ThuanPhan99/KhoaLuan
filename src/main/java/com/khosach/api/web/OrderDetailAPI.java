/*
 * @author THUAN-PHAN
 * @date May 28, 2020
 * @version 1.0
 */

package com.khosach.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.khosach.service.IOrderDetailService;

@RestController(value = "orderDetailAPIOfWeb")
public class OrderDetailAPI {
	@Autowired
	IOrderDetailService orderDetailService;

	@DeleteMapping("/api/orderdetailweb/{orderDetailID}")
	public ResponseEntity<?> deleteOder(@PathVariable(value = "orderDetailID", required = false) long orderDetailID) {
		orderDetailService.deleteOrdetail(orderDetailID);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/api/web/orderdetail")
	public ResponseEntity<?> orer() {
		return ResponseEntity.ok(orderDetailService.findRevenue());
	}
}
