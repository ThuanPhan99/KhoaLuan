/*
 * @author THUAN-PHAN
 * @date May 25, 2020
 * @version 1.0
 */

package com.khosach.service;

import java.util.List;

import com.khosach.dto.OrderCartDTO;
import com.khosach.dto.OrderDTO;

public interface IOrderService {
	void save_order(OrderCartDTO orderCartDTO, int status);

	long findOrderIDMax();

	List<OrderDTO> findAllByStatus(int status);

	OrderDTO updateOrder(long orderID, int status);

	List<OrderDTO> findAllByUserIDAndStatus(int status);

	List<OrderDTO> findAllByUserID();

	List<OrderDTO> findAllByUserIDAndOrderDetailStatus(int status);

	long totalPrice(long orderID);
	
	List<OrderDTO> findAllByStatusCancel();

	void saveOrderPay(OrderCartDTO orderCartDTO);

}
