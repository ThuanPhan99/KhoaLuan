/*
 * @author THUAN-PHAN
 * @date May 23, 2020
 * @version 1.0
 */

package com.khosach.controller.web;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.dto.CartDTO;
import com.khosach.service.ICartService;
import com.khosach.util.CheckUserLogin;
import com.khosach.util.SecurityUtils;

@Controller
public class CartController {

	@Autowired
	CheckUserLogin checkUserLogin;

	@Autowired
	ICartService cartService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/gio-hang", method = RequestMethod.GET)
	public ModelAndView cartPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("web/cart/cart");
		HashMap<Long, CartDTO> listCart = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");
		if (listCart == null) {
			listCart = new HashMap<>();
			if (checkUserLogin.checkUser()) {
				listCart = cartService.findAllByUserID(SecurityUtils.getPrincipal().getUserID());
			}
		} else {
			if (checkUserLogin.checkUser()) {
				cartService.saveListCart(listCart);
				session.setAttribute("myCartItems", null);
				listCart = cartService.findAllByUserID(SecurityUtils.getPrincipal().getUserID());
			}
		}
		mav.addObject("listCart", listCart);
		mav.addObject("totalPrice", cartService.totalPrice(listCart));
		return mav;
	}


}
