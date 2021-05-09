package com.khosach.mapper;

import com.khosach.dto.UserDTO;
import com.khosach.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-22T19:19:09+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserDTO toUserDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( userEntity.getId() );
        userDTO.setFullName( userEntity.getFullName() );
        userDTO.setUserName( userEntity.getUserName() );
        userDTO.setAddress( userEntity.getAddress() );
        userDTO.setNumberPhone( userEntity.getNumberPhone() );
        userDTO.setEmail( userEntity.getEmail() );
        userDTO.setGender( userEntity.getGender() );
        userDTO.setDateOfBirth( userEntity.getDateOfBirth() );
        userDTO.setPassword( userEntity.getPassword() );
        userDTO.setStatus( userEntity.getStatus() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toListUserDTO(List<UserEntity> listUserEntity) {
        if ( listUserEntity == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( listUserEntity.size() );
        for ( UserEntity userEntity : listUserEntity ) {
            list.add( toUserDTO( userEntity ) );
        }

        return list;
    }

    @Override
    public UserEntity toUserEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDTO.getId() );
        userEntity.setAddress( userDTO.getAddress() );
        userEntity.setNumberPhone( userDTO.getNumberPhone() );
        userEntity.setEmail( userDTO.getEmail() );
        userEntity.setGender( userDTO.getGender() );
        userEntity.setDateOfBirth( userDTO.getDateOfBirth() );
        if ( userDTO.getStatus() != null ) {
            userEntity.setStatus( userDTO.getStatus() );
        }
        userEntity.setPassword( userDTO.getPassword() );
        userEntity.setFullName( userDTO.getFullName() );
        userEntity.setUserName( userDTO.getUserName() );

        return userEntity;
    }

    @Override
    public List<UserEntity> toListUserEntity(List<UserDTO> listUserDTO) {
        if ( listUserDTO == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( listUserDTO.size() );
        for ( UserDTO userDTO : listUserDTO ) {
            list.add( toUserEntity( userDTO ) );
        }

        return list;
    }
}
