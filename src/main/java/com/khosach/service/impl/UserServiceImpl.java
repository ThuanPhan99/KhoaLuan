/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.khosach.dto.OrderCartDTO;
import com.khosach.dto.PasswordDTO;
import com.khosach.dto.UserDTO;
import com.khosach.entity.RoleEntity;
import com.khosach.entity.UserEntity;
import com.khosach.mapper.IUserMapper;
import com.khosach.repository.IUserRepository;
import com.khosach.service.ICRUDService;
import com.khosach.service.IUserService;
import com.khosach.util.SecurityUtils;

@Service
public class UserServiceImpl implements ICRUDService<UserDTO>, IUserService {

	@Autowired
	IUserRepository userRepository;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public List<UserDTO> findAll() {
		return IUserMapper.INSTANCE.toListUserDTO(userRepository.findAllByStatus(1));
	}

	@Override
	public UserDTO findById(long id) {
		UserEntity user = userRepository.findOne(id);
		return IUserMapper.INSTANCE.toUserDTO(user);
	}

	@Override
	public void delete(long[] ids) {
		for(long id: ids) {
			delete(id);
		}
	}

	@Override
	public void save(UserDTO dto) {
		UserEntity user = new UserEntity();
		if (dto.getId() != null) {
			UserEntity userEntity = userRepository.findOne(dto.getId());
			dto.setPassword(userEntity.getPassword());
			dto.setStatus(userEntity.getStatus());
			dto.setUserName(userEntity.getUserName());
			user = IUserMapper.INSTANCE.toUserEntity(dto);
			user.setRoles(userEntity.getRoles());
		} else {
			dto.setStatus(1);
			String password = passwordEncoder.encode(dto.getPassword());
			dto.setPassword(password);
			user = IUserMapper.INSTANCE.toUserEntity(dto);
			List<RoleEntity> listRole = new ArrayList<>();
			RoleEntity roleEntity = new RoleEntity();
			roleEntity.setId(2);
			listRole.add(roleEntity);
			user.setRoles(listRole);
		}
		userRepository.save(user);

	}

	@Override
	public UserDTO updateUser_Oder(OrderCartDTO user) {
		UserEntity userEntity = userRepository.findOne(user.getUserID());
		userEntity.setFullName(user.getFullName());
		userEntity.setEmail(user.getEmail());
		userEntity.setNumberPhone(user.getNumberPhone());
		userEntity.setAddress(user.getAddress());
		return IUserMapper.INSTANCE.toUserDTO(userRepository.save(userEntity));
	}

	@Override
	public void delete(long id) {
		UserEntity user = userRepository.findOne(id);
		user.setStatus(0);
		userRepository.save(user);
	}

	@Override
	public UserDTO updatePassword(PasswordDTO passwordDTO) {
		UserEntity userEntity = userRepository.findOne(SecurityUtils.getPrincipal().getUserID());
		if (passwordEncoder.matches(passwordDTO.getPasswordOld(), userEntity.getPassword())) {
			userEntity.setPassword(passwordEncoder.encode(passwordDTO.getPasswordNew()));
			UserDTO user = IUserMapper.INSTANCE.toUserDTO(userRepository.save(userEntity));
			return user;
		}
		return null;
	}

	@Override
	public boolean checkUserName(String userName) {
		UserEntity userEntity = userRepository.findFirstByUserName(userName);
		if (userEntity == null)
			return true;
		return false;
	}

	@Override
	public boolean checkPhone(String phone) {
		UserEntity userEntity = userRepository.findFirstByNumberPhone(phone);
		if (userEntity == null)
			return true;
		return false;
	}

	@Override
	public boolean checkEmail(String email) {
		UserEntity userEntity = userRepository.findFirstByEmail(email);
		if (userEntity == null)
			return true;
		return false;
	}

	@Override
	public int checkRegister(UserDTO userDTO) {
		if (checkUserName(userDTO.getUserName())) {
			if (checkPhone(userDTO.getNumberPhone())) {
				if (checkEmail(userDTO.getEmail())) {
					save(userDTO);
					return 3;
				} else {
					return 2;
				}
			} else {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public List<UserDTO> findAllUser() {
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		List<UserEntity> listUserEntity = userRepository.findAllByStatus(1);
		for(UserEntity userEntity : listUserEntity) {
			for(RoleEntity roleEntity : userEntity.getRoles() ) {
				if(roleEntity.getCode().equals("USER")) {
					listUserDTO.add(IUserMapper.INSTANCE.toUserDTO(userEntity));
					break;
				}
			}
		}
		return listUserDTO;
	}

	@Override
	public List<UserDTO> findAllAdmin() {
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		List<UserEntity> listUserEntity = userRepository.findAllByStatus(1);
		for(UserEntity userEntity : listUserEntity) {
			for(RoleEntity roleEntity : userEntity.getRoles() ) {
				if(roleEntity.getCode().equals("ADMIN")) {
					listUserDTO.add(IUserMapper.INSTANCE.toUserDTO(userEntity));
					break;
				}
			}
		}
		return listUserDTO;
	}

	@Override
	public UserDTO saveAdmin(UserDTO dto) {
		UserEntity user = new UserEntity();
		if (dto.getId() != null) {
			UserEntity userEntity = userRepository.findOne(dto.getId());
			dto.setPassword(userEntity.getPassword());
			dto.setStatus(userEntity.getStatus());
			//dto.setUserName(userEntity.getUserName());
			user = IUserMapper.INSTANCE.toUserEntity(dto);
			user.setRoles(userEntity.getRoles());
		} else {
			dto.setStatus(1);
			String password = passwordEncoder.encode(dto.getPassword());
			dto.setPassword(password);
			user = IUserMapper.INSTANCE.toUserEntity(dto);
			List<RoleEntity> listRole = new ArrayList<>();
			RoleEntity roleEntity = new RoleEntity();
			roleEntity.setId(1);
			listRole.add(roleEntity);
			user.setRoles(listRole);
		}
		 userRepository.save(user);
		return dto;
	}

	@Override
	public int checkRegisterAdmin(UserDTO userDTO) {
		UserEntity userEntity = userRepository.findFirstByUserName(userDTO.getUserName());
		if (Objects.isNull(userEntity) || Objects.equals(userEntity.getId(), userDTO.getId())) {
			UserEntity userEntityP = userRepository.findFirstByNumberPhone(userDTO.getNumberPhone());
			if (Objects.isNull(userEntityP) || Objects.equals(userEntityP.getId(), userDTO.getId())) {
				UserEntity userEntityE = userRepository.findFirstByEmail(userDTO.getEmail());
				if (Objects.isNull(userEntityE) || Objects.equals(userEntityE.getId(), userDTO.getId())) {
					saveAdmin(userDTO);
					return 3;
				} else {
					return 2;
				}
			} else {
				return 1;
			}
		}
		return 0;
	}

}
