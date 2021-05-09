package com.khosach.mapper;

import com.khosach.dto.ProductSaleDTO;
import com.khosach.entity.ProductEntity;
import com.khosach.entity.ProductSaleEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-22T19:19:09+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class IProductSaleMapperImpl implements IProductSaleMapper {

    @Override
    public ProductSaleDTO toProductSaleDTO(ProductSaleEntity productSaleEntity) {
        if ( productSaleEntity == null ) {
            return null;
        }

        ProductSaleDTO productSaleDTO = new ProductSaleDTO();

        productSaleDTO.setThumbnail( productSaleEntityProductThumbnail( productSaleEntity ) );
        productSaleDTO.setProductID( productSaleEntityProductProductID( productSaleEntity ) );
        productSaleDTO.setProductName( productSaleEntityProductProductName( productSaleEntity ) );
        productSaleDTO.setStatus( productSaleEntityProductStatus( productSaleEntity ) );
        productSaleDTO.setProductSaleID( productSaleEntity.getProductSaleID() );
        productSaleDTO.setSale( productSaleEntity.getSale() );

        return productSaleDTO;
    }

    @Override
    public List<ProductSaleDTO> toListProductSaleDTO(List<ProductSaleEntity> listPoductEntity) {
        if ( listPoductEntity == null ) {
            return null;
        }

        List<ProductSaleDTO> list = new ArrayList<ProductSaleDTO>( listPoductEntity.size() );
        for ( ProductSaleEntity productSaleEntity : listPoductEntity ) {
            list.add( toProductSaleDTO( productSaleEntity ) );
        }

        return list;
    }

    @Override
    public ProductSaleEntity toProductSaleEntity(ProductSaleDTO productSaleDTO) {
        if ( productSaleDTO == null ) {
            return null;
        }

        ProductSaleEntity productSaleEntity = new ProductSaleEntity();

        productSaleEntity.setProduct( productSaleDTOToProductEntity( productSaleDTO ) );
        productSaleEntity.setProductSaleID( productSaleDTO.getProductSaleID() );
        productSaleEntity.setSale( productSaleDTO.getSale() );

        return productSaleEntity;
    }

    @Override
    public List<ProductSaleEntity> toListProductSaleEntity(List<ProductSaleDTO> listProductSaleDTO) {
        if ( listProductSaleDTO == null ) {
            return null;
        }

        List<ProductSaleEntity> list = new ArrayList<ProductSaleEntity>( listProductSaleDTO.size() );
        for ( ProductSaleDTO productSaleDTO : listProductSaleDTO ) {
            list.add( toProductSaleEntity( productSaleDTO ) );
        }

        return list;
    }

    private String productSaleEntityProductThumbnail(ProductSaleEntity productSaleEntity) {
        if ( productSaleEntity == null ) {
            return null;
        }
        ProductEntity product = productSaleEntity.getProduct();
        if ( product == null ) {
            return null;
        }
        String thumbnail = product.getThumbnail();
        if ( thumbnail == null ) {
            return null;
        }
        return thumbnail;
    }

    private Long productSaleEntityProductProductID(ProductSaleEntity productSaleEntity) {
        if ( productSaleEntity == null ) {
            return null;
        }
        ProductEntity product = productSaleEntity.getProduct();
        if ( product == null ) {
            return null;
        }
        Long productID = product.getProductID();
        if ( productID == null ) {
            return null;
        }
        return productID;
    }

    private String productSaleEntityProductProductName(ProductSaleEntity productSaleEntity) {
        if ( productSaleEntity == null ) {
            return null;
        }
        ProductEntity product = productSaleEntity.getProduct();
        if ( product == null ) {
            return null;
        }
        String productName = product.getProductName();
        if ( productName == null ) {
            return null;
        }
        return productName;
    }

    private Integer productSaleEntityProductStatus(ProductSaleEntity productSaleEntity) {
        if ( productSaleEntity == null ) {
            return null;
        }
        ProductEntity product = productSaleEntity.getProduct();
        if ( product == null ) {
            return null;
        }
        Integer status = product.getStatus();
        if ( status == null ) {
            return null;
        }
        return status;
    }

    protected ProductEntity productSaleDTOToProductEntity(ProductSaleDTO productSaleDTO) {
        if ( productSaleDTO == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductID( productSaleDTO.getProductID() );
        productEntity.setStatus( productSaleDTO.getStatus() );
        productEntity.setProductName( productSaleDTO.getProductName() );
        productEntity.setThumbnail( productSaleDTO.getThumbnail() );

        return productEntity;
    }
}
