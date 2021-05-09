package com.khosach.mapper;

import com.khosach.dto.CategoryDTO;
import com.khosach.entity.CategoryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-22T19:19:09+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class ICategoryMapperImpl implements ICategoryMapper {

    @Override
    public CategoryDTO toCategoryDTO(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setPicture( categoryEntity.getPicture() );
        categoryDTO.setCategoryID( categoryEntity.getCategoryID() );
        categoryDTO.setCategoryName( categoryEntity.getCategoryName() );

        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> toListCategoryDTO(List<CategoryEntity> listCategoryEntity) {
        if ( listCategoryEntity == null ) {
            return null;
        }

        List<CategoryDTO> list = new ArrayList<CategoryDTO>( listCategoryEntity.size() );
        for ( CategoryEntity categoryEntity : listCategoryEntity ) {
            list.add( toCategoryDTO( categoryEntity ) );
        }

        return list;
    }

    @Override
    public CategoryEntity toCategoryEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setPicture( categoryDTO.getPicture() );
        categoryEntity.setCategoryID( categoryDTO.getCategoryID() );
        categoryEntity.setCategoryName( categoryDTO.getCategoryName() );

        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> toListCategoryEntity(List<CategoryDTO> listCategoryDTO) {
        if ( listCategoryDTO == null ) {
            return null;
        }

        List<CategoryEntity> list = new ArrayList<CategoryEntity>( listCategoryDTO.size() );
        for ( CategoryDTO categoryDTO : listCategoryDTO ) {
            list.add( toCategoryEntity( categoryDTO ) );
        }

        return list;
    }
}
