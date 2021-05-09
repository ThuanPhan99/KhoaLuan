/*
 * @author THUAN-PHAN
 * @date May 30, 2020
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

@RestController
public class SearchAPI {
	@Autowired
	IProductService productService;
	@GetMapping("/api/search/{key}")
	public ResponseEntity<?> search(@PathVariable(value = "key", required = false) String key) {
		return ResponseEntity.ok(productService.findAllNameByKey(key));
	}
	@GetMapping("/api/search/{search}/{page}/{limit}")
	public ResponseEntity<?> searchPaging(@PathVariable(value = "search", required = false) String search,
			@PathVariable(value = "page", required = false) int  page,
			@PathVariable(value = "limit", required = false) int limit) {
		Pageable pageable = new PageRequest(page - 1, limit);
		List<ProductDTO> listProduct = productService.findAllProductByKeySearch(search,pageable); 
		return ResponseEntity.ok(listProduct);
	}
}
