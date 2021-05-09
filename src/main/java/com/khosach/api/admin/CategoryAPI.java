/*
 * @author THUAN-PHAN
 * @date May 15, 2020
 * @version 1.0
 */

package com.khosach.api.admin;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khosach.dto.CategoryDTO;
import com.khosach.service.ICRUDService;
import com.khosach.service.ICategoryService;
import com.khosach.util.UploadFileUtils;
@RestController(value = "categoryAPIOfAdmin")
public class CategoryAPI {

	@Autowired
	ICRUDService<CategoryDTO> categoryCRUDService;
	
	@Autowired
	UploadFileUtils uploadFileUtils;
	
	@Autowired
	ICategoryService categoryService;
	@PostMapping("/api/category")
	public ResponseEntity<Void> uploadFile(@RequestBody CategoryDTO categoryDTO,HttpServletRequest request) {
		byte[] decodeBase64 = Base64.getDecoder().decode(categoryDTO.getBase64().split(",")[1].getBytes());
		uploadFileUtils.writeOrUpdate(decodeBase64, request.getServletContext().getRealPath("/image/category"),request.getServletContext().getRealPath("/image/category/") + categoryDTO.getPicture());
		categoryCRUDService.save(categoryDTO);

		return ResponseEntity.noContent().build();
	}
	@PutMapping("/api/category")
	public ResponseEntity<Void> updateFile(@RequestBody CategoryDTO categoryDTO,HttpServletRequest request){
		if(categoryDTO.getPicture()!=null) {
			byte[] decodeBase64 = Base64.getDecoder().decode(categoryDTO.getBase64().split(",")[1].getBytes());
			uploadFileUtils.writeOrUpdate(decodeBase64, request.getServletContext().getRealPath("/image/category"),request.getServletContext().getRealPath("/image/category/") + categoryDTO.getPicture());
			categoryCRUDService.save(categoryDTO);
		}else {
			CategoryDTO categoryDTO2 = categoryCRUDService.findById(categoryDTO.getCategoryID());
			categoryDTO.setPicture(categoryDTO2.getPicture());
			categoryCRUDService.save(categoryDTO);
		}
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/api/category")
	public ResponseEntity<?> deleteCategory(@RequestBody long categoryID) {
		int rs =0;
		if(categoryService.checkCategory(categoryID)) {
			return ResponseEntity.status(HttpStatus.OK).body(rs);
		}
		rs=1;
		categoryCRUDService.delete(categoryID);
		return ResponseEntity.status(HttpStatus.OK).body(rs);
	}
}
