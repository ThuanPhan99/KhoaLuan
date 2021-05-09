/*
 * @author THUAN-PHAN
 * @date May 23, 2020
 * @version 1.0
 */

package com.khosach.dto;

import com.khosach.entity.CartEntity;
import com.khosach.entity.ProductEntity;
import com.khosach.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {
	private Long cartID;
	private Long quantity;
	private ProductDTO product;
	private Long userID;

	public Long getCartID() {
		return cartID;
	}

	public void setCartID(Long cartID) {
		this.cartID = cartID;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}


	public static CartDTO toCartDTO(CartEntity cartEntity) {
		if ( cartEntity == null ) {
			return null;
		}

		CartDTO cartDTO = new CartDTO();

		cartDTO.setUserID( cartEntityUsersId( cartEntity ) );
		cartDTO.setProduct( ProductDTO.toProductDTO( cartEntity.getProducts() ) );
		cartDTO.setCartID( cartEntity.getCartID() );
		cartDTO.setQuantity( cartEntity.getQuantity() );

		return cartDTO;
	}

	public static List<CartDTO> toListCartDTO(List<CartEntity> listCartEntity) {
		if ( listCartEntity == null ) {
			return null;
		}

		List<CartDTO> list = new ArrayList<CartDTO>( listCartEntity.size() );
		for ( CartEntity cartEntity : listCartEntity ) {
			list.add( toCartDTO( cartEntity ) );
		}

		return list;
	}

	public static CartEntity toCartEntity(CartDTO cartDTO) {
		if ( cartDTO == null ) {
			return null;
		}

		CartEntity cartEntity = new CartEntity();

		cartEntity.setUserId( cartDTO.getUserID());
		cartEntity.setProductId( cartDTO.getProduct().getProductID() );
		cartEntity.setCartID( cartDTO.getCartID() );
		cartEntity.setQuantity( cartDTO.getQuantity() );

		return cartEntity;
	}

	public List<CartEntity> toListCartEntity(List<CartDTO> listCartDTO) {
		if ( listCartDTO == null ) {
			return null;
		}

		List<CartEntity> list = new ArrayList<CartEntity>( listCartDTO.size() );
		for ( CartDTO cartDTO : listCartDTO ) {
			list.add( toCartEntity( cartDTO ) );
		}

		return list;
	}

	private static Long cartEntityUsersId(CartEntity cartEntity) {
		if ( cartEntity == null ) {
			return null;
		}
		UserEntity users = cartEntity.getUsers();
		if ( users == null ) {
			return null;
		}
		Long id = users.getId();
		if ( id == null ) {
			return null;
		}
		return id;
	}



	protected static UserEntity cartDTOToUserEntity(CartDTO cartDTO) {
		if ( cartDTO == null ) {
			return null;
		}

		UserEntity userEntity = new UserEntity();

		userEntity.setId( cartDTO.getUserID() );

		return userEntity;
	}


}
