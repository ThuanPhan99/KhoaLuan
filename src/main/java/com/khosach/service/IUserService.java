/*
 * @author THUAN-PHAN
 * @date May 2, 2020
 * @version 1.0
 */

package com.khosach.service;

import java.util.List;

import com.khosach.dto.OrderCartDTO;
import com.khosach.dto.PasswordDTO;
import com.khosach.dto.UserDTO;

public interface IUserService {
	UserDTO updateUser_Oder(OrderCartDTO user);
	UserDTO updatePassword(PasswordDTO passwordDTO);
	boolean checkUserName(String userName);
	boolean checkPhone(String phone);
	boolean checkEmail(String email);
	int checkRegister(UserDTO dto);
	List<UserDTO> findAllUser();
	List<UserDTO> findAllAdmin();
	UserDTO saveAdmin(UserDTO dto);
	int checkRegisterAdmin(UserDTO dto);
}
