/*
 * @author THUAN-PHAN
 * @date May 27, 2020
 * @version 1.0
 */

package com.khosach.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khosach.dto.PasswordDTO;
import com.khosach.dto.UserDTO;
import com.khosach.service.ICRUDService;
import com.khosach.service.IUserService;

@RestController(value = "userAPIOfWeb")
public class UserAPI {
	@Autowired
	ICRUDService<UserDTO> userCRUDService;
	
	@Autowired
	IUserService userService;
	@PutMapping("/api/user")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO) {
		userCRUDService.save(userDTO);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/api/userupdatepassword")
	public ResponseEntity<?> updatePassword(@RequestBody PasswordDTO passwordDTO) {
		return ResponseEntity.ok(userService.updatePassword(passwordDTO));
	}
	@PostMapping("/api/user")
	public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
		return ResponseEntity.ok(userService.checkRegister(userDTO));
	}
}
