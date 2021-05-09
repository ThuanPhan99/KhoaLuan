/*
 * @author THUAN-PHAN
 * @date May 20, 2020
 * @version 1.0
 */

package com.khosach.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.service.IProductService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	@Autowired
	IProductService productSaleService;
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage2() {
		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("listProductSale",productSaleService.findAllProductSale());
		return mav;
	}
}
