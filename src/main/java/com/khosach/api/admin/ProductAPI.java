/*
 * @author THUAN-PHAN
 * @date May 18, 2020
 * @version 1.0
 */

package com.khosach.api.admin;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.khosach.dto.*;
import com.khosach.service.IOrderDetailService;
import com.khosach.service.IOrderService;
import com.khosach.service.impl.AuthorsServiceImpl;
import com.khosach.service.impl.PublishersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.khosach.service.ICRUDService;
import com.khosach.util.UploadFileUtils;

@RestController
public class ProductAPI {
	@Autowired
	UploadFileUtils uploadFileUtils;
	
	@Autowired
	ICRUDService<ProductDTO> productService;

	@Autowired
	AuthorsServiceImpl authorsService;

	@Autowired
	PublishersServiceImpl publishersService;

	@PostMapping("/api/product")
	public ResponseEntity<Void> uploadFile(@RequestBody ProductDTO productDTO,HttpServletRequest request) {
		byte[] decodeBase64 = Base64.getDecoder().decode(productDTO.getBase64().split(",")[1].getBytes());
		uploadFileUtils.writeOrUpdate(decodeBase64, request.getServletContext().getRealPath("/image/product"),request.getServletContext().getRealPath("/image/product/") + productDTO.getThumbnail());
		productService.save(productDTO);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/api/product")
	public ResponseEntity<Void> updateFile(@RequestBody ProductDTO productDTO,HttpServletRequest request){
		if(productDTO.getThumbnail()!=null) {
			byte[] decodeBase64 = Base64.getDecoder().decode(productDTO.getBase64().split(",")[1].getBytes());
			uploadFileUtils.writeOrUpdate(decodeBase64, request.getServletContext().getRealPath("/image/product"),request.getServletContext().getRealPath("/image/product/") + productDTO.getThumbnail());
			productService.save(productDTO);
		}else {
			ProductDTO productDTO2 = productService.findById(productDTO.getProductID());
			productDTO.setThumbnail(productDTO2.getThumbnail());
			productService.save(productDTO);
		}
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/api/product")
	public void deleteNew(@RequestBody long[] ids) {
		productService.delete(ids);
	}

	@PostMapping("/api/author")
	public ResponseEntity<?> addAuthor(@RequestBody AuthorDTO authorDTO) {
		authorsService.saveAuthor(authorDTO);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/api/publisher")
	public ResponseEntity<?> addPublisher(@RequestBody PublisherDTO publisherDTO) {
		publishersService.savePublisher(publisherDTO);
		return ResponseEntity.noContent().build();
	}

}
