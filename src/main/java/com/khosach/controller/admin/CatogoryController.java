/*
 * @author THUAN-PHAN
 * @date May 14, 2020
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

import com.khosach.dto.CategoryDTO;
import com.khosach.service.ICRUDService;

@Controller(value = "categoryControllerOfAdmin")
public class CatogoryController {
	
	@Autowired
	ICRUDService<CategoryDTO> categoryService;
	
	@RequestMapping(value = "/quan-tri/the-loai", method = RequestMethod.GET)
	public ModelAndView categoryPage() {
		ModelAndView mav = new ModelAndView("admin/category/category");
		mav.addObject("listCategory",categoryService.findAll());
		return mav;
	}
	@RequestMapping(value = "/quan-tri/the-loai/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editCategoryPage(@RequestParam(value="id",required = false) Long id, HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView("admin/category/editCategories");// sai cái view này
		CategoryDTO categoryDTO = new CategoryDTO();
		if(id!=null) {
			categoryDTO = categoryService.findById(id);
		}
		mav.addObject("model",categoryDTO);
		return mav;
	}


}
