/*
 * @author THUAN-PHAN
 * @date May 25, 2020
 * @version 1.0
 */

package com.khosach.api.web;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.khosach.payment.PaymentService;
import com.khosach.payment.allinone.models.CaptureMoMoResponse;
import com.khosach.service.impl.OrderServiceImpl;
import com.khosach.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.khosach.dto.OrderCartDTO;
import com.khosach.dto.OrderDTO;
import com.khosach.service.IOrderDetailService;
import com.khosach.service.IOrderService;
import com.khosach.service.IUserService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController(value = "orderAPIOfWeb")
public class OrderAPI {
	@Autowired
	IUserService userService;
	
	@Autowired
	IOrderService orderService;

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	IOrderDetailService oderDetailService;
	
	@PostMapping("api/order")
	public ResponseEntity<?> addOrder(@RequestBody OrderCartDTO orderCartDTO) {
		orderCartDTO.setUserID(SecurityUtils.getPrincipal().getUserID());
		userService.updateUser_Oder(orderCartDTO);
		orderService.save_order(orderCartDTO, 1);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("api/order/{status}")
	public ResponseEntity<?> hrOder(@PathVariable(value = "status", required = false) int status) {
		List<OrderDTO> listOrderDetail = new ArrayList<OrderDTO>();
		if(status==0) {
			listOrderDetail = orderService.findAllByUserID();
		}else {
			listOrderDetail = orderService.findAllByUserIDAndStatus(status);
		}
		return ResponseEntity.ok(listOrderDetail);
	}
	@DeleteMapping("api/order/{orderID}")
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "orderID", required = false) int orderID) {
		orderService.updateOrder(orderID, 5);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("api/orderMomo")
	public ResponseEntity<?> orderMomo(@RequestBody OrderCartDTO orderCartDTO) throws Exception {
		orderCartDTO.setUserID(SecurityUtils.getPrincipal().getUserID());
		String orderId = String.valueOf(System.currentTimeMillis());
		CaptureMoMoResponse captureMoMoResponse = paymentService.payMomo(orderCartDTO, orderId);
		return ResponseEntity.ok(captureMoMoResponse);
	}

	@RequestMapping(value = "/paymentSuccess", method = RequestMethod.GET)
	public ModelAndView paymentSuccess(@RequestParam(value="errorCode",required = false) int errorCode,
									   @RequestParam(value="orderId",required = false) String orderId,
									   @RequestParam(value="extraData",required = false) String extraData,
									   @RequestParam(value="requestId",required = false) String requestId) {
		if (errorCode == 0){
			ModelAndView mav = new ModelAndView("web/order/orderFinish");
			try {
				System.out.println(extraData);
				Gson g = new Gson();
				OrderCartDTO orderCartDTO = g.fromJson(extraData, OrderCartDTO.class);
				orderService.saveOrderPay(orderCartDTO);
				Thread.sleep(4000);
				return mav;
			} catch(InterruptedException ex) {
				return mav;
			}
		} else {
			try {
				Thread.sleep(4000);
				return new ModelAndView("web/order/orderFails");
			} catch (InterruptedException e) {
				return new ModelAndView("web/order/orderFails");
			}
		}
	}
}
