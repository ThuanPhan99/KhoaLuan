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

import com.khosach.dto.GroupProductDTO;
import com.khosach.repository.IGroupProductRepository;
import com.khosach.service.ICRUDService;
import com.khosach.service.ICategoryService;

@Controller(value = "groupProductControllerOfAdmin")
public class GroupProductController {
	@Autowired
	ICRUDService<GroupProductDTO> groupProductService;
	
	@Autowired
	IGroupProductRepository groupProductRepository;
	
	@Autowired
	ICategoryService categoryService;
	
	@RequestMapping(value = "/quan-tri/nhom-san-pham", method = RequestMethod.GET)
	public ModelAndView groupProuctPage() {
		ModelAndView mav = new ModelAndView("admin/groupProduct/groupProduct");
		mav.addObject("listGroupProduct",groupProductService.findAll());
		return mav;
	}
	@RequestMapping(value = "/quan-tri/nhom-san-pham/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editGroupProuctPage(@RequestParam(value="id",required = false) Long id, HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView("admin/groupProduct/editGroupProduct");
		GroupProductDTO groupProductDTO = new GroupProductDTO();
		if(id!=null) {
			groupProductDTO = groupProductService.findById(id);
		}
		mav.addObject("groupProducts",categoryService.findAllCategoryDTO());
		mav.addObject("model",groupProductDTO);
		return mav;
	}
}
