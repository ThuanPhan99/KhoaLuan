package com.khosach.mapper;

import com.khosach.dto.GroupProductDTO;
import com.khosach.entity.CategoryEntity;
import com.khosach.entity.GroupProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-22T19:19:09+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class IGroupProductMapperImpl implements IGroupProductMapper {

    @Override
    public GroupProductDTO togroupProductDTO(GroupProductEntity groupProductEntity) {
        if ( groupProductEntity == null ) {
            return null;
        }

        GroupProductDTO groupProductDTO = new GroupProductDTO();

        groupProductDTO.setCategoryName( groupProductEntityCategoryCategoryName( groupProductEntity ) );
        groupProductDTO.setCategoryID( groupProductEntityCategoryCategoryID( groupProductEntity ) );
        groupProductDTO.setGroupProductID( groupProductEntity.getGroupProductID() );
        groupProductDTO.setGroupProductName( groupProductEntity.getGroupProductName() );

        return groupProductDTO;
    }

    @Override
    public List<GroupProductDTO> tolistGroupProducDTO(List<GroupProductEntity> listGroupProductEntity) {
        if ( listGroupProductEntity == null ) {
            return null;
        }

        List<GroupProductDTO> list = new ArrayList<GroupProductDTO>( listGroupProductEntity.size() );
        for ( GroupProductEntity groupProductEntity : listGroupProductEntity ) {
            list.add( togroupProductDTO( groupProductEntity ) );
        }

        return list;
    }

    @Override
    public GroupProductEntity toGroupProductEntity(GroupProductDTO groupProductDTO) {
        if ( groupProductDTO == null ) {
            return null;
        }

        GroupProductEntity groupProductEntity = new GroupProductEntity();

        groupProductEntity.setCategory( groupProductDTOToCategoryEntity( groupProductDTO ) );
        groupProductEntity.setGroupProductID( groupProductDTO.getGroupProductID() );
        groupProductEntity.setGroupProductName( groupProductDTO.getGroupProductName() );

        return groupProductEntity;
    }

    @Override
    public List<GroupProductEntity> toListGroupProductEntity(List<GroupProductDTO> listroupProductDTO) {
        if ( listroupProductDTO == null ) {
            return null;
        }

        List<GroupProductEntity> list = new ArrayList<GroupProductEntity>( listroupProductDTO.size() );
        for ( GroupProductDTO groupProductDTO : listroupProductDTO ) {
            list.add( toGroupProductEntity( groupProductDTO ) );
        }

        return list;
    }

    private String groupProductEntityCategoryCategoryName(GroupProductEntity groupProductEntity) {
        if ( groupProductEntity == null ) {
            return null;
        }
        CategoryEntity category = groupProductEntity.getCategory();
        if ( category == null ) {
            return null;
        }
        String categoryName = category.getCategoryName();
        if ( categoryName == null ) {
            return null;
        }
        return categoryName;
    }

    private Long groupProductEntityCategoryCategoryID(GroupProductEntity groupProductEntity) {
        if ( groupProductEntity == null ) {
            return null;
        }
        CategoryEntity category = groupProductEntity.getCategory();
        if ( category == null ) {
            return null;
        }
        Long categoryID = category.getCategoryID();
        if ( categoryID == null ) {
            return null;
        }
        return categoryID;
    }

    protected CategoryEntity groupProductDTOToCategoryEntity(GroupProductDTO groupProductDTO) {
        if ( groupProductDTO == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategoryID( groupProductDTO.getCategoryID() );
        categoryEntity.setCategoryName( groupProductDTO.getCategoryName() );

        return categoryEntity;
    }
}
