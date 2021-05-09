/*
 * @author THUAN-PHAN
 * @date May 21, 2020
 * @version 1.0
 */

package com.khosach.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.dto.UserDTO;
import com.khosach.service.ICRUDService;
import com.khosach.util.SecurityUtils;

@Controller
public class UserInformationController {
	@Autowired
	ICRUDService<UserDTO> userService;
	@RequestMapping(value = "/thong-tin-tai-khoan", method = RequestMethod.GET)
	public ModelAndView infoPage() {
		ModelAndView mav = new ModelAndView("web/user/information");
		mav.addObject("user",userService.findById(SecurityUtils.getPrincipal().getUserID()));
		return mav;
	}
	@RequestMapping(value = "/thay-doi-mat-khau", method = RequestMethod.GET)
	public ModelAndView updatePasswordPage() {
		ModelAndView mav = new ModelAndView("web/user/updatePassword");
		return mav;
	}

}
