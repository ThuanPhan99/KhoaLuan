/*
 * @author THUAN-PHAN
 * @date May 31, 2020
 * @version 1.0
 */

package com.khosach.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.khosach.dto.ProductDTO;
import com.khosach.service.IProductService;

@RestController(value = "groupProductAPIOfWeb")
public class GroupProductAPI {
	@Autowired
	IProductService productService;

	@GetMapping("/api/web/groupproduct/{id}/{page}/{limit}")
	public ResponseEntity<?> productByGroupProductPaging(@PathVariable(value = "id", required = false) long id,
			@PathVariable(value = "page", required = false) int page,
			@PathVariable(value = "limit", required = false) int limit) {
		Pageable pageable = new PageRequest(page - 1, limit);
		List<ProductDTO> listProduct = productService.findAllByGroupProductID(id, pageable);
		return ResponseEntity.ok(listProduct);
	}
}
