/*

package com.khosach.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.dto.GroupCategoryDTO;
import com.khosach.service.IGroupCategoryService;

@Controller(value = "groupCategoryControllerOfAdmin")
public class GroupCategoryController {

	@Autowired
	IGroupCategoryService groupCategoryService;

	@RequestMapping(value = "/quan-tri/nhom-the-loai", method = RequestMethod.GET)
	public ModelAndView groupCategoryPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/groupCategory/groupCategories");
		mav.addObject("listGroupCategory", groupCategoryService.findAll());
		return mav;
	}
	@RequestMapping(value = "/quan-tri/nhom-the-loai/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editGroupCategoryPage(@RequestParam(value="id",required = false) Long id, HttpServletRequest request ) {
		ModelAndView mav = new ModelAndView("admin/groupCategory/editGgroupCategories");
		GroupCategoryDTO model = new GroupCategoryDTO();
		if(id!=null) {
			model = groupCategoryService.findByID(id);
		}
	    mav.addObject("model", model);
		return mav;
	}
}
*/