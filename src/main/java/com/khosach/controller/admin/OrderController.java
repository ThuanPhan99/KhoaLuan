/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.dto.OrderDTO;
import com.khosach.service.ICRUDService;
import com.khosach.service.IOrderService;

@Controller(value = "orderControllerOfAdmin")
public class OrderController {
	@Autowired
	ICRUDService<OrderDTO> orderService;
	
	@Autowired
	IOrderService orderService2;
	@RequestMapping(value = "/quan-tri/don-hang/tat-ca", method = RequestMethod.GET)
	public ModelAndView allOrderPage() {
		ModelAndView mav = new ModelAndView("admin/order/allOrder");
		mav.addObject("listOrder",orderService.findAll());
		return mav;
	}
	@RequestMapping(value = "/quan-tri/don-hang/chua-duyet", method = RequestMethod.GET)
	public ModelAndView notApprovaledPage() {
		ModelAndView mav = new ModelAndView("admin/order/notApprovaled");
		mav.addObject("listOrder",orderService2.findAllByStatus(1));
		return mav;
	}
	@RequestMapping(value = "/quan-tri/don-hang/da-duyet", method = RequestMethod.GET)
	public ModelAndView approvaledPage() {
		ModelAndView mav = new ModelAndView("admin/order/approvaled");
		mav.addObject("listOrder",orderService2.findAllByStatus(2));
		return mav;
	}
	@RequestMapping(value = "/quan-tri/don-hang/dang-giao-hang", method = RequestMethod.GET)
	public ModelAndView deliveryPage() {
		ModelAndView mav = new ModelAndView("admin/order/delivery");
		mav.addObject("listOrder",orderService2.findAllByStatus(3));
		return mav;
	}
	@RequestMapping(value = "/quan-tri/don-hang/da-thanh-toan", method = RequestMethod.GET)
	public ModelAndView deliveredPage() {
		ModelAndView mav = new ModelAndView("admin/order/delivered");
		mav.addObject("listOrder",orderService2.findAllByStatus(4));
		return mav;
	}
	@RequestMapping(value = "/quan-tri/don-hang/da-hoan-thanh", method = RequestMethod.GET)
	public ModelAndView successPage() {
		ModelAndView mav = new ModelAndView("admin/order/success");
		mav.addObject("listOrder",orderService2.findAllByStatus(6));
		return mav;
	}
	@RequestMapping(value = "/quan-tri/don-hang/da-huy", method = RequestMethod.GET)
	public ModelAndView cancelledPage() {
		ModelAndView mav = new ModelAndView("admin/order/cancelled");
		mav.addObject("listOrder",orderService2.findAllByStatusCancel());
		return mav;
	}
}
