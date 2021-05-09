/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.khosach.dto.CartDTO;
import com.khosach.dto.OrderDetailDTO;
import com.khosach.dto.ProductSaleDTO;
import com.khosach.dto.RevenueDTO;
import com.khosach.entity.OrderDetailEntity;
import com.khosach.mapper.IOrderDetailMapper;
import com.khosach.repository.IOrderDetailRepository;
import com.khosach.service.ICRUDService;
import com.khosach.service.IOrderDetailService;
import com.khosach.service.IOrderService;
import com.khosach.service.IProductSaleService;
import com.khosach.service.IProductService;

@Service
public class OrderDetailServiceImpl implements ICRUDService<OrderDetailDTO>, IOrderDetailService {

	@Autowired
	IOrderDetailRepository orderDetailRepository;

	@Autowired
	IProductService productService;

	@Autowired
	IOrderService orderService;

	@Autowired
	IProductSaleService productSaleService;

	@Override
	public List<OrderDetailDTO> findAll() {
		return IOrderDetailMapper.INSTANCE.toListOrderDetailDTO(orderDetailRepository.findAll());
	}

	@Override
	public OrderDetailDTO findById(long id) {
		return null;
	}

	@Override
	public void delete(long[] ids) {

	}

	@Override
	@Transactional
	public void save(OrderDetailDTO dto) {
		OrderDetailEntity orderDetailEntity = IOrderDetailMapper.INSTANCE.toOrderDetailEntity(dto);
		orderDetailRepository.save(orderDetailEntity);
	}

	@Override
	public List<OrderDetailDTO> findAllOrderDetailByOrderID(Long orderID) {
		return IOrderDetailMapper.INSTANCE.toListOrderDetailDTO(orderDetailRepository.findAllByOrders_OrderID(orderID));
	}

	@Override
	public void saveOrderDetail(CartDTO cartDTO, long orderID) {
		ProductSaleDTO productSaleDTO = productSaleService.findByProductID(cartDTO.getProduct().getProductID());
		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		orderDetailDTO.setOrderID(orderID);
		orderDetailDTO.setQuantity(cartDTO.getQuantity());
		if (productSaleDTO != null) {
			orderDetailDTO.setPrice((cartDTO.getProduct().getPrice() * (100 - productSaleDTO.getSale()) / 100));
		} else {
			orderDetailDTO
					.setPrice((cartDTO.getProduct().getPrice() * (100 - cartDTO.getProduct().getSalePrice()) / 100));
		}

		orderDetailDTO.setProductID(cartDTO.getProduct().getProductID());
		orderDetailDTO.setStatus(1);
		save(orderDetailDTO);
	}

	@Override
	public List<Long> checkOrderApprovaled(long orderID) {
		List<Long> productIDs = new ArrayList<Long>();
		List<OrderDetailEntity> listOrderDetail = orderDetailRepository.findAllByOrders_OrderID(orderID);
		for (OrderDetailEntity orderDetail : listOrderDetail) {
			if (productService.checkQuantity(orderDetail.getProducts().getProductID(), orderDetail.getQuantity())) {
				productIDs.add(orderDetail.getProducts().getProductID());
			}
		}
		return productIDs;
	}

	@Override
	public void deleteOrdetail(Long orderDetailID) {
		OrderDetailEntity orderDetailEntity = orderDetailRepository.findOne(orderDetailID);
		orderDetailEntity.setStatus(0);
		orderDetailRepository.save(orderDetailEntity);
		checkUpdateOrderCancel(orderDetailEntity.getOrders().getOrderID());
	}

	@Override
	public void updateQuantityOrderDetaill(long orderID) {
		List<OrderDetailEntity> listOrderDetail = orderDetailRepository.findAllByOrders_OrderID(orderID);
		for (OrderDetailEntity orderDetail : listOrderDetail) {
			productService.updateQuantity(orderDetail.getProducts().getProductID(), orderDetail.getQuantity());
		}

	}

	@Override
	public void delete(long id) {

	}

	@Override
	public List<OrderDetailDTO> findAllOrderDetailByOrderIDAndStatus(Long orderID, int status) {
		List<OrderDetailEntity> listOrderDetailEntity = orderDetailRepository.findAllByOrders_OrderIDAndStatus(orderID,
				status);
		return IOrderDetailMapper.INSTANCE.toListOrderDetailDTO(listOrderDetailEntity);
	}

	@Override
	@Transactional
	public void checkUpdateOrderCancel(long orderID) {
		List<OrderDetailEntity> listOrderDetail = orderDetailRepository.findAllByOrders_OrderID(orderID);
		List<OrderDetailEntity> listOrderDetailCancel = orderDetailRepository.findAllByOrders_OrderIDAndStatus(orderID,
				0);
		if (listOrderDetail.size() == listOrderDetailCancel.size()) {
			orderService.updateOrder(orderID, 5);
		}

	}

	@Override
	@Transactional
	public void updateStatus(long orderID) {
		List<OrderDetailEntity> listOrderDetail = orderDetailRepository.findAllByOrders_OrderID(orderID);
		for (OrderDetailEntity orderDetail : listOrderDetail) {
			orderDetail.setStatus(0);
			orderDetailRepository.save(orderDetail);
		}

	}

	@Override
	public String findRevenue() {
		List<RevenueDTO> listRevenueDTO = orderDetailRepository.findRevenue();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.getWeekYear();
		int yearStart = 2016;
		int totalYear = year - yearStart;
		String revenue;
		if(listRevenueDTO.size() > 0){
			revenue =listRevenueDTO.get(0).getTotalPrice().toString();
			//if (totalYear != listRevenueDTO.size()) {
			for (int i = 1; i < totalYear; i++) {
				if (yearStart + i < listRevenueDTO.get(i).getYear()) {
					int m = listRevenueDTO.get(i).getYear() - (yearStart + i);
					if (m == 1) {
						RevenueDTO revenueDTO = new RevenueDTO((long) 0, yearStart + i);
						listRevenueDTO.add(i, revenueDTO);
					} else {
						for (int j = 0; j < m; j++) {
							RevenueDTO revenueDTO = new RevenueDTO((long) 0, yearStart + i + j);
							listRevenueDTO.add(i + j, revenueDTO);

						}
					}
				}
			}
			//}
			for(int i=1;i<listRevenueDTO.size();i++) {
				revenue +=","+listRevenueDTO.get(i).getTotalPrice().toString();
			}
		} else {
			revenue = "0";
			for (int i = 1; i < totalYear; i++) {
				revenue +=",0";
			}
		}

		return revenue;
	}

}
