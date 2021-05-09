/*
 * @author THUAN-PHAN
 * @date May 23, 2020
 * @version 1.0
 */

package com.khosach.service;

import java.util.HashMap;
import java.util.List;

import com.khosach.dto.CartDTO;

public interface ICartService {
	HashMap<Long, CartDTO> addCart(HashMap<Long, CartDTO> carts, long productID , long quantity);
	HashMap<Long, CartDTO> updateCart(HashMap<Long, CartDTO> carts, long productID , long quantity );
	HashMap<Long, CartDTO> deteleCart(HashMap<Long, CartDTO> carts, long productID);
	HashMap<Long, CartDTO> findAllByUserID(long userID);
	void saveListCart(HashMap<Long, CartDTO> listCart);
	void addCart(long productID , long quantity);
	CartDTO updateCart(long productID , long quantity);
	void delete(long productID);
	void deleteAll();
	long totalQuantity(HashMap<Long, CartDTO> listCart);
	long totalQuantity();// database
	long totalPrice(HashMap<Long, CartDTO> listCart);
	List<CartDTO> findAllByProductIDAndUserID(String prodcutID, Long userID);
	long totalPrice(List<CartDTO> listCart);
	void delete(long productID, long userID);

}
