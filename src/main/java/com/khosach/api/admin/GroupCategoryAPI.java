/*
 * @author THUAN-PHAN
 * @date May 13, 2020
 * @version 1.0
 

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

import com.khosach.dto.GroupCategoryDTO;
import com.khosach.service.IGroupCategoryService;
import com.khosach.util.UploadFileUtils;

@RestController(value = "groupCategoryAPIOfAdmin")
public class GroupCategoryAPI {
	@Autowired
	UploadFileUtils uploadFileUtils;
	@Autowired
	IGroupCategoryService groupCategoryService;
	
	private ServletContext servletContext;
	
	@PostMapping("/api/groupcategory")
	public ResponseEntity<Void> uploadFile(@RequestBody GroupCategoryDTO groupCategoryDTO,HttpServletRequest request) {
		byte[] decodeBase64 = Base64.getDecoder().decode(groupCategoryDTO.getBase64().split(",")[1].getBytes());
		uploadFileUtils.writeOrUpdate(decodeBase64, request.getServletContext().getRealPath("image/GroupCategory"),request.getServletContext().getRealPath("image/GroupCategory/") + groupCategoryDTO.getPicture());
		groupCategoryService.save(groupCategoryDTO);

		return ResponseEntity.noContent().build();
	}
	@PutMapping("/api/groupcategory")
	public ResponseEntity<Void> updateFile(@RequestBody GroupCategoryDTO groupCategoryDTO,HttpServletRequest request){
		if(groupCategoryDTO.getPicture()!=null) {
			byte[] decodeBase64 = Base64.getDecoder().decode(groupCategoryDTO.getBase64().split(",")[1].getBytes());
			Path path = Paths.get(this.servletContext.getRealPath("/image/groupCategory"));
			Path path2 = Paths.get(this.servletContext.getRealPath("/image/groupCategory/")+ groupCategoryDTO.getPicture());
			System.out.println(path.toString() + path2.toString());
			uploadFileUtils.writeOrUpdate(decodeBase64, request.getServletContext().getRealPath("image/GroupCategory"),request.getServletContext().getRealPath("image/GroupCategory/") + groupCategoryDTO.getPicture());
			groupCategoryService.save(groupCategoryDTO);
		}else {
			GroupCategoryDTO groupCategoryDTO2 = groupCategoryService.findByID(groupCategoryDTO.getGroupCategoriesID());
			groupCategoryDTO.setPicture(groupCategoryDTO2.getPicture());
			groupCategoryService.save(groupCategoryDTO);
		}
		
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("/api/groupcategory")
	public ResponseEntity<?> deleteNew(@RequestBody long groupCategoryID) {
		int rs =0;
		if(groupCategoryService.checkGroupCategory(groupCategoryID)) {
			return ResponseEntity.status(HttpStatus.OK).body(rs);
		}
		rs=1;
		groupCategoryService.delete(groupCategoryID);
		return ResponseEntity.status(HttpStatus.OK).body(rs);
	}
}
*/