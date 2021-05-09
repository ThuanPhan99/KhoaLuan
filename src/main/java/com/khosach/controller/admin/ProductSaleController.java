/*
 * @author THUAN-PHAN
 * @date May 16, 2020
 * @version 1.0
 */

package com.khosach.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.dto.ProductSaleDTO;
import com.khosach.service.ICRUDService;

@Controller(value = "productSaleControllerOfAdmin")
public class ProductSaleController {
	
	@Autowired
	ICRUDService<ProductSaleDTO> productSaleService;
	
	@RequestMapping(value = "/quan-tri/san-pham-khuyen-mai", method = RequestMethod.GET)
	public ModelAndView groupProuctPage() {
		ModelAndView mav = new ModelAndView("admin/productSale/productSale");
		mav.addObject("listProductSale",productSaleService.findAll());
		return mav;
	}
	@RequestMapping(value = "/quan-tri/san-pham-khuyen-mai/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editGroupProuctPage(@RequestParam(value="id",required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/productSale/editProductSale");
		ProductSaleDTO productSaleDTO = new ProductSaleDTO();
		if(id!=null) {
			productSaleDTO = productSaleService.findById(id);
		}
		mav.addObject("model",productSaleDTO);
		return mav;
	}
}
