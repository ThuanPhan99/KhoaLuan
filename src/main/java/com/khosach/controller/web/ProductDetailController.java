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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.dto.ProductDTO;
import com.khosach.service.ICRUDService;

@Controller
public class ProductDetailController {
	@Autowired
	ICRUDService<ProductDTO> productService;
	@RequestMapping(value = "/chi-tiet-san-pham", method = RequestMethod.GET)
	public ModelAndView productDetailPage(@RequestParam(value="id",required = false) Long id) {
		ModelAndView mav = new ModelAndView("web/productDetail");
		mav.addObject("product",productService.findById(id));
		return mav;
	}
}
