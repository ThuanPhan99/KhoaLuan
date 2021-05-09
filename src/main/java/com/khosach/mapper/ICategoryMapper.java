/*
 * @author THUAN-PHAN
 * @date May 14, 2020
 * @version 1.0
 */

package com.khosach.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.khosach.dto.CategoryDTO;
import com.khosach.entity.CategoryEntity;

@Mapper
public interface ICategoryMapper {

	ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);

	CategoryDTO toCategoryDTO(CategoryEntity categoryEntity);

	List<CategoryDTO> toListCategoryDTO(List<CategoryEntity> listCategoryEntity);

	CategoryEntity toCategoryEntity(CategoryDTO categoryDTO);

	List<CategoryEntity> toListCategoryEntity(List<CategoryDTO> listCategoryDTO);
}
