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

import com.khosach.dto.GroupProductDTO;
import com.khosach.entity.GroupProductEntity;

@Mapper
public interface IGroupProductMapper {
	IGroupProductMapper INSTANCE = Mappers.getMapper(IGroupProductMapper.class);

	@Mappings({ 
		@Mapping(source = "groupProductEntity.category.categoryID", target = "categoryID"),
		@Mapping(source = "groupProductEntity.category.categoryName", target = "categoryName") })
	GroupProductDTO togroupProductDTO(GroupProductEntity groupProductEntity);

	List<GroupProductDTO> tolistGroupProducDTO(List<GroupProductEntity> listGroupProductEntity);

	@Mappings({ 
		@Mapping(source = "groupProductDTO.categoryID", target = "category.categoryID"),
		@Mapping(source = "groupProductDTO.categoryName", target = "category.categoryName") 
		})
	GroupProductEntity toGroupProductEntity(GroupProductDTO groupProductDTO);

	List<GroupProductEntity> toListGroupProductEntity(List<GroupProductDTO> listroupProductDTO);
}
