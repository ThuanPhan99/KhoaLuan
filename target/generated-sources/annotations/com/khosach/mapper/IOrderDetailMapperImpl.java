package com.khosach.mapper;

import com.khosach.dto.OrderDetailDTO;
import com.khosach.entity.OrderDetailEntity;
import com.khosach.entity.OrderEntity;
import com.khosach.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-22T19:19:09+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class IOrderDetailMapperImpl implements IOrderDetailMapper {

    @Override
    public OrderDetailDTO toOrderDetailDTO(OrderDetailEntity orderDetailEntity) {
        if ( orderDetailEntity == null ) {
            return null;
        }

        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();

        orderDetailDTO.setThumbnail( orderDetailEntityProductsThumbnail( orderDetailEntity ) );
        orderDetailDTO.setProductID( orderDetailEntityProductsProductID( orderDetailEntity ) );
        orderDetailDTO.setOrderID( orderDetailEntityOrdersOrderID( orderDetailEntity ) );
        orderDetailDTO.setProductName( orderDetailEntityProductsProductName( orderDetailEntity ) );
        orderDetailDTO.setStatus( orderDetailEntity.getStatus() );
        orderDetailDTO.setOrderDetailID( orderDetailEntity.getOrderDetailID() );
        orderDetailDTO.setQuantity( orderDetailEntity.getQuantity() );
        orderDetailDTO.setPrice( orderDetailEntity.getPrice() );

        return orderDetailDTO;
    }

    @Override
    public List<OrderDetailDTO> toListOrderDetailDTO(List<OrderDetailEntity> listOrderDetailEntity) {
        if ( listOrderDetailEntity == null ) {
            return null;
        }

        List<OrderDetailDTO> list = new ArrayList<OrderDetailDTO>( listOrderDetailEntity.size() );
        for ( OrderDetailEntity orderDetailEntity : listOrderDetailEntity ) {
            list.add( toOrderDetailDTO( orderDetailEntity ) );
        }

        return list;
    }

    @Override
    public OrderDetailEntity toOrderDetailEntity(OrderDetailDTO orderDetailDTO) {
        if ( orderDetailDTO == null ) {
            return null;
        }

        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();

        orderDetailEntity.setProducts( orderDetailDTOToProductEntity( orderDetailDTO ) );
        orderDetailEntity.setOrders( orderDetailDTOToOrderEntity( orderDetailDTO ) );
        orderDetailEntity.setStatus( orderDetailDTO.getStatus() );
        orderDetailEntity.setOrderDetailID( orderDetailDTO.getOrderDetailID() );
        orderDetailEntity.setQuantity( orderDetailDTO.getQuantity() );
        orderDetailEntity.setPrice( orderDetailDTO.getPrice() );

        return orderDetailEntity;
    }

    @Override
    public List<OrderDetailEntity> toListOrderDetailEntity(List<OrderDetailDTO> listOrderDetailDTO) {
        if ( listOrderDetailDTO == null ) {
            return null;
        }

        List<OrderDetailEntity> list = new ArrayList<OrderDetailEntity>( listOrderDetailDTO.size() );
        for ( OrderDetailDTO orderDetailDTO : listOrderDetailDTO ) {
            list.add( toOrderDetailEntity( orderDetailDTO ) );
        }

        return list;
    }

    private String orderDetailEntityProductsThumbnail(OrderDetailEntity orderDetailEntity) {
        if ( orderDetailEntity == null ) {
            return null;
        }
        ProductEntity products = orderDetailEntity.getProducts();
        if ( products == null ) {
            return null;
        }
        String thumbnail = products.getThumbnail();
        if ( thumbnail == null ) {
            return null;
        }
        return thumbnail;
    }

    private Long orderDetailEntityProductsProductID(OrderDetailEntity orderDetailEntity) {
        if ( orderDetailEntity == null ) {
            return null;
        }
        ProductEntity products = orderDetailEntity.getProducts();
        if ( products == null ) {
            return null;
        }
        Long productID = products.getProductID();
        if ( productID == null ) {
            return null;
        }
        return productID;
    }

    private Long orderDetailEntityOrdersOrderID(OrderDetailEntity orderDetailEntity) {
        if ( orderDetailEntity == null ) {
            return null;
        }
        OrderEntity orders = orderDetailEntity.getOrders();
        if ( orders == null ) {
            return null;
        }
        Long orderID = orders.getOrderID();
        if ( orderID == null ) {
            return null;
        }
        return orderID;
    }

    private String orderDetailEntityProductsProductName(OrderDetailEntity orderDetailEntity) {
        if ( orderDetailEntity == null ) {
            return null;
        }
        ProductEntity products = orderDetailEntity.getProducts();
        if ( products == null ) {
            return null;
        }
        String productName = products.getProductName();
        if ( productName == null ) {
            return null;
        }
        return productName;
    }

    protected ProductEntity orderDetailDTOToProductEntity(OrderDetailDTO orderDetailDTO) {
        if ( orderDetailDTO == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductID( orderDetailDTO.getProductID() );
        productEntity.setProductName( orderDetailDTO.getProductName() );
        productEntity.setThumbnail( orderDetailDTO.getThumbnail() );

        return productEntity;
    }

    protected OrderEntity orderDetailDTOToOrderEntity(OrderDetailDTO orderDetailDTO) {
        if ( orderDetailDTO == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderID( orderDetailDTO.getOrderID() );

        return orderEntity;
    }
}
