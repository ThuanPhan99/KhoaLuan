package com.khosach.mapper;

import com.khosach.dto.OrderDTO;
import com.khosach.entity.OrderEntity;
import com.khosach.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-22T19:19:09+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class IOrderMapperImpl implements IOrderMapper {

    @Override
    public OrderDTO toOrderDTO(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setUserid( orderEntityUsersId( orderEntity ) );
        orderDTO.setOrderID( orderEntity.getOrderID() );
        orderDTO.setStatus( orderEntity.getStatus() );
        orderDTO.setDateOfIssue( orderEntity.getDateOfIssue() );
        orderDTO.setPaymentMethods( orderEntity.getPaymentMethods() );
        orderDTO.setDeliveryDate( orderEntity.getDeliveryDate() );

        return orderDTO;
    }

    @Override
    public List<OrderDTO> toListOrderDTO(List<OrderEntity> listOrderEntity) {
        if ( listOrderEntity == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( listOrderEntity.size() );
        for ( OrderEntity orderEntity : listOrderEntity ) {
            list.add( toOrderDTO( orderEntity ) );
        }

        return list;
    }

    @Override
    public OrderEntity toOrderEntity(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setUsers( orderDTOToUserEntity( orderDTO ) );
        orderEntity.setDeliveryDate( orderDTO.getDeliveryDate() );
        orderEntity.setOrderID( orderDTO.getOrderID() );
        orderEntity.setStatus( orderDTO.getStatus() );
        orderEntity.setDateOfIssue( orderDTO.getDateOfIssue() );
        orderEntity.setPaymentMethods( orderDTO.getPaymentMethods() );

        return orderEntity;
    }

    @Override
    public List<OrderEntity> toListOrderEntity(List<OrderDTO> listOrderDTO) {
        if ( listOrderDTO == null ) {
            return null;
        }

        List<OrderEntity> list = new ArrayList<OrderEntity>( listOrderDTO.size() );
        for ( OrderDTO orderDTO : listOrderDTO ) {
            list.add( toOrderEntity( orderDTO ) );
        }

        return list;
    }

    private Long orderEntityUsersId(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }
        UserEntity users = orderEntity.getUsers();
        if ( users == null ) {
            return null;
        }
        Long id = users.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected UserEntity orderDTOToUserEntity(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( orderDTO.getUserid() );

        return userEntity;
    }
}
