/*
 * @author THUAN-PHAN
 * @date May 14, 2020
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

@Controller(value = "categoryControllerOfWeb")
public class CatogoryController {
	@Autowired
	IProductService productService;

	@RequestMapping(value = "/san-pham-theo-the-loai", method = RequestMethod.GET)
	public ModelAndView productCategoryPage(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "1000") Integer limit) {
		ModelAndView mav = new ModelAndView("web/categoryProduct");
		Pageable pageable = new PageRequest(page - 1, limit);
		mav.addObject("listProduct", productService.findAllByCatetogyID(id, pageable));
		mav.addObject("page", page);
		mav.addObject("limit", limit);
		mav.addObject("search", id);
		mav.addObject("url", "/api/web/category");
		long totalProduct = (long) Math.ceil((double) productService.totalProductByCatetogyID(id) / limit);
		mav.addObject("totalProduct", totalProduct);
		return mav;
	}

}
