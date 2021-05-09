/*
 * @author THUAN-PHAN
 * @date May 15, 2020
 * @version 1.0
 */

package com.khosach.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.khosach.dto.ProductDTO;
import com.khosach.entity.ProductEntity;

@Mapper
public interface IProductMapper {
	IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);
/*
	@Mappings({ @Mapping(source = "productEntity.groupProductEntity.groupProductID", target = "groupProductID"),
			@Mapping(source = "productEntity.groupProductEntity.groupProductName", target = "groupProductName"),
			@Mapping(source = "productEntity.productPrice.price", target = "price"),
			@Mapping(source = "productEntity.productPrice.saleOff", target = "salePrice"),
			@Mapping(source = "productEntity.publishersEntity.name", target = "publisher"),
			@Mapping(source = "productEntity.isDelete", target = "delete")})
	ProductDTO toProductDTO(ProductEntity productEntity);

	List<ProductDTO> toListProductDTO(List<ProductEntity> listProductEntity);

	@Mappings({ @Mapping(source = "productDTO.groupProductID", target = "groupProductEntity.groupProductID"),
			@Mapping(source = "productDTO.groupProductName", target = "groupProductEntity.groupProductName"),
			@Mapping(source = "productDTO.delete", target = "isDelete")})
	ProductEntity toProductEntity(ProductDTO productDTO);

	List<ProductEntity> toListProductEntity(List<ProductDTO> listProductDTO);*/

}
