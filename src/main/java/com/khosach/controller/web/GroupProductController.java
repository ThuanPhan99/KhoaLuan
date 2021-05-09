/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.service.IProductService;

@Controller(value = "groupProductControllerOfWeb")
public class GroupProductController {
	@Autowired
	IProductService productService;

	@RequestMapping(value = "/san-pham-theo-nhom-san-pham", method = RequestMethod.GET)
	public ModelAndView productGroupProductPage(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "1000") Integer limit) {
		ModelAndView mav = new ModelAndView("web/categoryProduct");
		Pageable pageable = new PageRequest(page - 1, limit);
		mav.addObject("listProduct", productService.findAllByGroupProductID(id, pageable));
		mav.addObject("page", page);
		mav.addObject("limit", limit);
		mav.addObject("search", id);
		mav.addObject("url", "/api/web/groupproduct");
		long totalProduct = (long) Math.ceil((double) productService.totalProductByGroupProductID(id) / limit);
		mav.addObject("totalProduct", totalProduct);
		return mav;
	}
}
