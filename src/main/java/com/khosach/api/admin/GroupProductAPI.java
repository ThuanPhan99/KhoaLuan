/*
 * @author THUAN-PHAN
 * @date May 18, 2020
 * @version 1.0
 */

package com.khosach.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khosach.dto.GroupProductDTO;
import com.khosach.service.ICRUDService;
import com.khosach.service.IGroupProductService;

@RestController(value = "groupProductAPIOfAdmin")
public class GroupProductAPI {
	@Autowired
	ICRUDService<GroupProductDTO> groupProductCRUDService;
	
	@Autowired
	IGroupProductService groupProductService;

	@PostMapping("/api/groupproduct")
	public ResponseEntity<?> addGroupProduct(@RequestBody GroupProductDTO groupProductDTO) {
		groupProductCRUDService.save(groupProductDTO);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/api/groupproduct")
	public ResponseEntity<?> updateGroupProduct(@RequestBody GroupProductDTO groupProductDTO) {
		groupProductCRUDService.save(groupProductDTO);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/api/groupproduct")
	public ResponseEntity<?> deleteGroupProduct(@RequestBody long groupProductID) {
		int rs =0;
		if(groupProductService.checkGroupProduct(groupProductID)) {
			return ResponseEntity.status(HttpStatus.OK).body(rs);
		}
		rs=1;
		groupProductCRUDService.delete(groupProductID);
		return ResponseEntity.status(HttpStatus.OK).body(rs);
	}
}
