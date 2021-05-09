/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.khosach.dto.ProductSaleDTO;
import com.khosach.entity.ProductSaleEntity;

@Mapper
public interface IProductSaleMapper {
    IProductSaleMapper INSTANCE = Mappers.getMapper(IProductSaleMapper.class);
	@Mappings({
		@Mapping(source="productSaleEntity.product.productID",target="productID"),
		@Mapping(source="productSaleEntity.product.productName",target="productName"),
		@Mapping(source="productSaleEntity.product.thumbnail",target="thumbnail"),
		@Mapping(source="productSaleEntity.product.status",target="status")
	})
	ProductSaleDTO toProductSaleDTO(ProductSaleEntity productSaleEntity);
	
	List<ProductSaleDTO> toListProductSaleDTO(List<ProductSaleEntity> listPoductEntity);
	@Mappings({
		@Mapping(source="productSaleDTO.productID",target="product.productID"),
		@Mapping(source="productSaleDTO.productName",target="product.productName"),
		@Mapping(source="productSaleDTO.thumbnail",target="product.thumbnail"),
		@Mapping(source="productSaleDTO.status",target="product.status")
	})
	ProductSaleEntity toProductSaleEntity(ProductSaleDTO productSaleDTO);
	
	List<ProductSaleEntity> toListProductSaleEntity(List<ProductSaleDTO> listProductSaleDTO);
}
