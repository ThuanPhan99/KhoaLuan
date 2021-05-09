/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.khosach.dto.OrderDTO;
import com.khosach.entity.OrderEntity;

@Mapper
public interface IOrderMapper {
	
	IOrderMapper INSTANCE = Mappers.getMapper(IOrderMapper.class);

	@Mapping(source = "orderEntity.users.id", target = "userid")
	OrderDTO toOrderDTO(OrderEntity orderEntity);

	List<OrderDTO> toListOrderDTO(List<OrderEntity> listOrderEntity);

	@Mapping(source = "orderDTO.userid", target = "users.id")
	OrderEntity toOrderEntity(OrderDTO orderDTO);

	List<OrderEntity> toListOrderEntity(List<OrderDTO> listOrderDTO);

}
