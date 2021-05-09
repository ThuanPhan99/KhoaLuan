/*
 * @author THUAN-PHAN
 * @date May 25, 2020
 * @version 1.0
 */

package com.khosach.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.dto.CartDTO;
import com.khosach.dto.OrderDTO;
import com.khosach.dto.UserDTO;
import com.khosach.service.ICRUDService;
import com.khosach.service.ICartService;
import com.khosach.service.IOrderDetailService;
import com.khosach.service.IOrderService;
import com.khosach.util.SecurityUtils;

@Controller(value = "orderControllerOfWeb")
public class OrderController {
	private static final Long shipAmount = 30000L;

	@Autowired
	ICRUDService<UserDTO> userService;

	@Autowired
	ICartService cartService;
	
	@Autowired
	IOrderDetailService orderDetailService;
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	ICRUDService<OrderDTO> orderCRUDService;

	@RequestMapping(value = "/dat-hang", method = RequestMethod.GET)
	public ModelAndView orderPage(@RequestParam(value = "id", required = false) String ids) {
		ModelAndView mav = new ModelAndView("web/order/order");
		List<CartDTO> listCart = cartService.findAllByProductIDAndUserID(ids, SecurityUtils.getPrincipal().getUserID());
		mav.addObject("listCartOrder", listCart);
		long ship = 0l;
		long totalAmount = cartService.totalPrice(listCart);
		if(totalAmount <= 300000){
			ship = shipAmount;
		}
		mav.addObject("shipAmount", ship);
		mav.addObject("totalPrice", totalAmount + ship);
		mav.addObject("model", userService.findById(SecurityUtils.getPrincipal().getUserID()));
		mav.addObject("productIDs", ids);
		return mav;
	}

	@RequestMapping(value = "/quan-ly-don-hang", method = RequestMethod.GET)
	public ModelAndView hROrderPage() {
		ModelAndView mav = new ModelAndView("web/user/allOrder");
		mav.addObject("listOrder",orderService.findAllByUserID());
		return mav;
	}

	@RequestMapping(value = "/quan-ly-don-hang-huy", method = RequestMethod.GET)
	public ModelAndView hROrderCancelPage() {
		ModelAndView mav = new ModelAndView("web/user/canceledOrder");
		mav.addObject("listOrder",orderService.findAllByUserIDAndOrderDetailStatus(0));
		return mav;
	}
	@RequestMapping(value = "/dat-hang-thanh-cong", method = RequestMethod.GET)
	public ModelAndView orderFinishPage() {
		ModelAndView mav = new ModelAndView("web/order/orderFinish");
		return mav;
	}
	@RequestMapping(value = "/chi-tiet-don-hang", method = RequestMethod.GET)
	public ModelAndView orderDetailPage(@RequestParam(value = "id", required = false) long orderID) {
		ModelAndView mav = new ModelAndView("web/user/orderDetail");
		OrderDTO orderDTO = orderCRUDService.findById(orderID);
		mav.addObject("order",orderDTO);
		mav.addObject("user", userService.findById(orderDTO.getUserid()));
		mav.addObject("totalPrice",orderService.totalPrice(orderID));
		return mav;
	}
	

}
