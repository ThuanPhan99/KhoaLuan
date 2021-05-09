/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.khosach.dto.OrderDetailDTO;
import com.khosach.service.IOrderDetailService;

@RestController(value = "orderDetailAPIOfAdmin")
public class OrderDetailAPI {

	@Autowired
	IOrderDetailService orderDetailService;

	@GetMapping("api/orderdetail/{id}")
	public ResponseEntity<List<OrderDetailDTO>> getAllOrderDetailByOrderID(@PathVariable("id") Long id) {
		return ResponseEntity.ok(orderDetailService.findAllOrderDetailByOrderID(id));
	} 
	@DeleteMapping("api/orderdetail/{id}")
	public ResponseEntity<?> deleteOrderDetail(@PathVariable("id") Long id) {
		orderDetailService.deleteOrdetail(id);
		return ResponseEntity.noContent().build();
	} 
}
