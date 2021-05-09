/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.khosach.dto.OrderDetailDTO;
import com.khosach.entity.OrderDetailEntity;

@Mapper
public interface IOrderDetailMapper {
	IOrderDetailMapper INSTANCE = Mappers.getMapper(IOrderDetailMapper.class);
	@Mappings({
		@Mapping(source="orderDetailEntity.products.productID",target="productID"),
		@Mapping(source="orderDetailEntity.products.productName",target="productName"),
		@Mapping(source="orderDetailEntity.products.thumbnail",target="thumbnail"),
		@Mapping(source="orderDetailEntity.orders.orderID",target="orderID")
	})
	OrderDetailDTO toOrderDetailDTO(OrderDetailEntity orderDetailEntity);
	
	List<OrderDetailDTO> toListOrderDetailDTO(List<OrderDetailEntity> listOrderDetailEntity);
	
	@Mappings({
		@Mapping(source="orderDetailDTO.productID",target="products.productID"),
		@Mapping(source="orderDetailDTO.productName",target="products.productName"),
		@Mapping(source="orderDetailDTO.thumbnail",target="products.thumbnail"),
		@Mapping(source="orderDetailDTO.orderID",target="orders.orderID")
	})
	OrderDetailEntity toOrderDetailEntity(OrderDetailDTO orderDetailDTO);
	
	List<OrderDetailEntity> toListOrderDetailEntity(List<OrderDetailDTO> listOrderDetailDTO);
}
