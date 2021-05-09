/*
 * @author THUAN-PHAN
 * @date May 23, 2020
 * @version 1.0
 */

package com.khosach.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.khosach.dto.CartDTO;
import com.khosach.entity.CartEntity;

@Mapper
public interface ICartMapper {
	ICartMapper INSTANCE = Mappers.getMapper(ICartMapper.class);

/*	@Mappings({ @Mapping(source = "cartEntity.products", target = "product"),
			@Mapping(source = "cartEntity.users.id", target = "userID") })
	CartDTO toCartDTO(CartEntity cartEntity);

	List<CartDTO> toListCartDTO(List<CartEntity> listCartEntity);

	@Mappings({ @Mapping(source = "cartDTO.product", target = "products"),
			@Mapping(source = "cartDTO.userID", target = "users.id") })
	CartEntity toCartEntity(CartDTO cartDTO);

	List<CartEntity> toListCartEntity(List<CartDTO> listCartDTO);*/
}
