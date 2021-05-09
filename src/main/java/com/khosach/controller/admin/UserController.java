/*
 * @author THUAN-PHAN
 * @date May 17, 2020
 * @version 1.0
 */

package com.khosach.controller.admin;

import com.khosach.dto.UserDTO;
import com.khosach.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.service.IUserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	@Autowired
	ICRUDService<UserDTO> icrudService;

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/quan-tri/khach-hang", method = RequestMethod.GET)
	public ModelAndView userPage() {
		ModelAndView mav = new ModelAndView("admin/user/user");
		mav.addObject("listUser", userService.findAllUser());
		return mav;
	}
	@RequestMapping(value = "/quan-tri/danh-sach-admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		ModelAndView mav = new ModelAndView("admin/user/admin");
		mav.addObject("listUser", userService.findAllAdmin());
		return mav;
	}

	@RequestMapping(value = "/quan-tri/admin-info", method = RequestMethod.GET)
	public ModelAndView adminInfoPage() {
		ModelAndView mav = new ModelAndView("admin/user/adminInfo");
		return mav;
	}

	@RequestMapping(value = "/quan-tri/admin-info/edit", method = RequestMethod.GET)
	public ModelAndView adminInfoPage(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/user/adminEditInfo");
		mav.addObject("user", icrudService.findById(id));
		return mav;
	}
}
