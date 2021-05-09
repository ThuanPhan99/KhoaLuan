/*
 * @author THUAN-PHAN
 * @date May 19, 2020
 * @version 1.0
 */

package com.khosach.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khosach.dto.ProductSaleDTO;
import com.khosach.service.ICRUDService;
import com.khosach.service.IProductSaleService;

@RestController
public class ProductSaleAPI {
	@Autowired
	ICRUDService<ProductSaleDTO> productSaleCRUDService;

	@Autowired
	IProductSaleService productSaleService;

	@PostMapping("/api/productsale")
	public ResponseEntity<?> addCategory(@RequestBody ProductSaleDTO productSaleDTO) {
		int check = productSaleService.checkAddProductSale(productSaleDTO.getProductID());
		if (check==0) {
			return ResponseEntity.ok(0);
		} else if (check==1) {
			return ResponseEntity.ok(1);
		}
		productSaleCRUDService.save(productSaleDTO);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/api/productsale")
	public ResponseEntity<?> updateCategory(@RequestBody ProductSaleDTO productSaleDTO) {
		productSaleCRUDService.save(productSaleDTO);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/api/productsale")
	public ResponseEntity<?> deleteNew(@RequestBody long[] ids) {
		productSaleCRUDService.delete(ids);
		return ResponseEntity.noContent().build();
	}
}
