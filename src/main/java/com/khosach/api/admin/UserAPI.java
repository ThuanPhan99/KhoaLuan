/*
 * @author THUAN-PHAN
 * @date May 29, 2020
 * @version 1.0
 */

package com.khosach.api.admin;

import com.khosach.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.khosach.dto.UserDTO;
import com.khosach.service.ICRUDService;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {
	@Autowired
	ICRUDService<UserDTO> userCRUDService;

	@Autowired
	UserServiceImpl userService;
	
	@DeleteMapping("/api/admin/user")
	public ResponseEntity<?> deleteUser(@RequestBody long[] userID) {
		userCRUDService.delete(userID);
		return ResponseEntity.noContent().build();
		
	}

	@PutMapping("/api/admin/user")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) {
		userService.saveAdmin(userDTO);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/api/admin/user")
	public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.checkRegisterAdmin(userDTO));
	}
}
