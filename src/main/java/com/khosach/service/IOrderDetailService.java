/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.service;

import java.util.List;

import com.khosach.dto.CartDTO;
import com.khosach.dto.OrderDetailDTO;

public interface IOrderDetailService {
	List<OrderDetailDTO> findAllOrderDetailByOrderID(Long orderID);

	void saveOrderDetail(CartDTO cartDTO, long orderID);

	List<Long> checkOrderApprovaled(long orderID);

	void deleteOrdetail(Long orderDetailID);

	void updateQuantityOrderDetaill(long orderID);

	List<OrderDetailDTO> findAllOrderDetailByOrderIDAndStatus(Long orderID, int status);
	
	void checkUpdateOrderCancel(long orderID);
	
	void updateStatus(long orderID);
	
	String  findRevenue();
}
