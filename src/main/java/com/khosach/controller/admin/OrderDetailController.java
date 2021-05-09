/*
 * @author THUAN-PHAN
 * @date Jun 1, 2020
 * @version 1.0
 */

package com.khosach.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.service.IOrderDetailService;

@Controller
public class OrderDetailController {
	@Autowired
	IOrderDetailService orderDetalService;

	@RequestMapping(value = "/quan-tri/Thong-ke/Bieu-do-doanh-thu", method = RequestMethod.GET)
	public ModelAndView groupProuctPage() {
		ModelAndView mav = new ModelAndView("admin/statistical/revenueChart");
		mav.addObject("revenue", orderDetalService.findRevenue());
		return mav;
	}
}
