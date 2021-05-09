/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.khosach.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khosach.dto.CartDTO;
import com.khosach.dto.OrderCartDTO;
import com.khosach.dto.OrderDTO;
import com.khosach.dto.OrderDetailDTO;
import com.khosach.entity.OrderEntity;
import com.khosach.mapper.IOrderMapper;
import com.khosach.repository.IOrderRepository;
import com.khosach.util.SecurityUtils;

@Service
public class OrderServiceImpl implements ICRUDService<OrderDTO>, IOrderService {

	@Autowired
	IOrderRepository orderRepository;

	@Autowired
	ICartService cartService;

	@Autowired
	IOrderDetailService orderDetailService;
	@Autowired
	IUserService userService;

	@Override
	public List<OrderDTO> findAll() {
		return IOrderMapper.INSTANCE.toListOrderDTO(orderRepository.findAll());
	}

	@Override
	public OrderDTO findById(long id) {
		OrderDTO orderDTO = IOrderMapper.INSTANCE.toOrderDTO(orderRepository.findOne(id));
		List<OrderDetailDTO> listOrDerDetail = orderDetailService.findAllOrderDetailByOrderID(id);
		orderDTO.setListOrDerDetail(listOrDerDetail);
		return orderDTO ;
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			OrderEntity order = orderRepository.findOne(id);
			order.setStatus(5);// trang thai hủy
			orderRepository.save(order);
		}

	}

	@Override
	@Transactional
	public void save(OrderDTO dto) {
		OrderEntity orderEntity = IOrderMapper.INSTANCE.toOrderEntity(dto);
		orderRepository.save(orderEntity);

	}

	@Override
	@Transactional
	public void save_order(OrderCartDTO orderCartDTO, int status) {
		List<CartDTO> listCartDTO = cartService.findAllByProductIDAndUserID(orderCartDTO.getProductIDs(), orderCartDTO.getUserID());
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setPaymentMethods(orderCartDTO.getPaymentMethods());
		orderDTO.setStatus(status);
		orderDTO.setUserid(orderCartDTO.getUserID());
		if(status==4) {
			Date date = new Date();
			orderDTO.setDeliveryDate(date);
		}
		save(orderDTO);
		long orderID = findOrderIDMax();
		for (CartDTO cart : listCartDTO) {
			orderDetailService.saveOrderDetail(cart, orderID);
			cartService.delete(cart.getProduct().getProductID(), orderCartDTO.getUserID());
		}
	}

	@Override
	public long findOrderIDMax() {
		OrderEntity orderEntity = orderRepository.findTop1ByOrderByOrderIDDesc();
		return orderEntity.getOrderID();
	}

	@Override
	public List<OrderDTO> findAllByStatus(int status) {
		List<OrderEntity> listOrderEntity = orderRepository.findAllByStatus(status);
		return IOrderMapper.INSTANCE.toListOrderDTO(listOrderEntity);
	}

	@Override
	public OrderDTO updateOrder(long orderID, int status) {
		OrderEntity orderEntity = orderRepository.findOne(orderID);
		if(status==4) {
			Date date = new Date();
			orderEntity.setDeliveryDate(date);
		}
		if(status==5) {
			orderDetailService.updateStatus(orderID);
		}
		orderEntity.setStatus(status);
		return IOrderMapper.INSTANCE.toOrderDTO(orderRepository.save(orderEntity));
	}

	@Override
	public void delete(long id) {
		
		
	}

	@Override
	public List<OrderDTO> findAllByUserIDAndStatus(int status) {
		List<OrderDTO> listOrderDTO = new ArrayList<OrderDTO>();
		List<OrderEntity> listOrderEntity = orderRepository.findAllByUsers_IdAndStatus(SecurityUtils.getPrincipal().getUserID(), status);
		for(OrderEntity order : listOrderEntity) {
			List<OrderDetailDTO> listOrderDetail = orderDetailService.findAllOrderDetailByOrderID(order.getOrderID());
			OrderDTO orderDTO = IOrderMapper.INSTANCE.toOrderDTO(order);
			orderDTO.setListOrDerDetail(listOrderDetail);
			listOrderDTO.add(orderDTO);
		}
		
		return listOrderDTO;
	}

	@Override
	public List<OrderDTO> findAllByUserID() {
		List<OrderDTO> listOrderDTO = new ArrayList<OrderDTO>();
		List<OrderEntity> listOrderEntity = orderRepository.findAllByUsers_Id(SecurityUtils.getPrincipal().getUserID());
		for(OrderEntity order : listOrderEntity) {
			List<OrderDetailDTO> listOrderDetail = orderDetailService.findAllOrderDetailByOrderID(order.getOrderID());
			OrderDTO orderDTO = IOrderMapper.INSTANCE.toOrderDTO(order);
			orderDTO.setListOrDerDetail(listOrderDetail);
			listOrderDTO.add(orderDTO);
		}
		return listOrderDTO;
	}

	@Override
	public List<OrderDTO> findAllByUserIDAndOrderDetailStatus(int status) {
		List<OrderDTO> listOrderDTO = new ArrayList<OrderDTO>();
		List<OrderEntity> listOrderEntity = orderRepository.findAllByUsers_Id(SecurityUtils.getPrincipal().getUserID());
		for(OrderEntity order : listOrderEntity) {
			List<OrderDetailDTO> listOrderDetail = orderDetailService.findAllOrderDetailByOrderIDAndStatus(order.getOrderID(), status);
			if(listOrderDetail.size()!=0) {
				OrderDTO orderDTO = IOrderMapper.INSTANCE.toOrderDTO(order);
				orderDTO.setListOrDerDetail(listOrderDetail);
				listOrderDTO.add(orderDTO);
			}
		}
		return listOrderDTO;
	}

	@Override
	public long totalPrice(long orderID) {
		long total=0;
		OrderDTO orderDTO = findById(orderID);
		for(OrderDetailDTO orderDetailDTO: orderDTO.getListOrDerDetail()) {
			total += orderDetailDTO.getTotally();
		}
		return total;
	}

	@Override
	public List<OrderDTO> findAllByStatusCancel() {
		List<OrderDTO> listOrderDTO = new ArrayList<OrderDTO>();
		List<OrderEntity> listOrderEntity = orderRepository.findAll();
		for(OrderEntity order : listOrderEntity) {
			List<OrderDetailDTO> listOrderDetail = orderDetailService.findAllOrderDetailByOrderIDAndStatus(order.getOrderID(), 0);
			if(listOrderDetail.size()!=0) {
				OrderDTO orderDTO = IOrderMapper.INSTANCE.toOrderDTO(order);
				listOrderDTO.add(orderDTO);
			}
		}
		return listOrderDTO;
	}

	@Override
	public void saveOrderPay(OrderCartDTO orderCartDTO){
			try {
				userService.updateUser_Oder(orderCartDTO);
				save_order(orderCartDTO, 4);
			}catch (Exception e){
				e.printStackTrace();
			}

	}

}
