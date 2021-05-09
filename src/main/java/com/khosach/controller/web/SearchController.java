/*
 * @author THUAN-PHAN
 * @date May 31, 2020
 * @version 1.0
 */

package com.khosach.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.dto.ProductDTO;
import com.khosach.service.IProductService;

@Controller
public class SearchController {
	@Autowired
	IProductService productService;

	@RequestMapping(value = "/tim-kiem", method = RequestMethod.GET)
	public ModelAndView searchPage(@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "page", required = false,defaultValue = "1") Integer page,
			@RequestParam(value = "limit", required = false,defaultValue = "1000") Integer limit, Model model) {
		Pageable pageable = new PageRequest(page - 1, limit);
		List<ProductDTO> listProduct = productService.findAllProductByKeySearch(search,pageable);
		/*if (listProduct.size() == 0) {
			return new ModelAndView("web/error");
		} else */if (listProduct.size() == 1) {
			model.addAttribute("product", listProduct.get(0));
			return new ModelAndView("web/productDetail");
		}
		model.addAttribute("page", page);
		model.addAttribute("limit", limit);
		model.addAttribute("url", "/api/search");
		model.addAttribute("search", search);
		if(listProduct.size() == 0){
			model.addAttribute("totalProduct",0);
		} else {
			long totalProduct = (long) Math.ceil((double) productService.totalProductSearch(search) / limit);
			model.addAttribute("totalProduct",totalProduct);
		}
		model.addAttribute("listProduct", listProduct);
		return new ModelAndView("web/categoryProduct");
	}
}
