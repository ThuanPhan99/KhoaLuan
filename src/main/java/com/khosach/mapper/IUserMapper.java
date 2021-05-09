/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.khosach.dto.UserDTO;
import com.khosach.entity.UserEntity;

@Mapper
public interface IUserMapper {
	IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

	UserDTO toUserDTO(UserEntity userEntity);

	List<UserDTO> toListUserDTO(List<UserEntity> listUserEntity);

	UserEntity toUserEntity(UserDTO userDTO);

	List<UserEntity> toListUserEntity(List<UserDTO> listUserDTO);
}
