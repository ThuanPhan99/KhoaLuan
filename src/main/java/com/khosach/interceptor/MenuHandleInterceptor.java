/*
 * @author THUAN-PHAN
 * @date May 19, 2020
 * @version 1.0
 */

package com.khosach.interceptor;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.khosach.dto.CartDTO;
import com.khosach.dto.CategoryDTO;
import com.khosach.dto.GroupProductDTO;
import com.khosach.service.ICRUDService;
import com.khosach.service.ICartService;
import com.khosach.util.CheckUserLogin;
import com.khosach.util.SecurityUtils;

public class MenuHandleInterceptor implements HandlerInterceptor {

	@Autowired
	ICRUDService<CategoryDTO> categoryService;

	@Autowired
	ICRUDService<GroupProductDTO> groupProductService;

	@Autowired
	CheckUserLogin checkUserLogin;

	@Autowired
	ICartService cartService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		long totalQuantity = 0;
		HashMap<Long, CartDTO> listCart = new HashMap<>();
		request.setAttribute("listMenuCategory", categoryService.findAll());
		request.setAttribute("listMenuGroupProduct", groupProductService.findAll());
		if (checkUserLogin.checkUser()) {
			totalQuantity = cartService.totalQuantity();
			listCart = cartService.findAllByUserID(SecurityUtils.getPrincipal().getUserID());
		} else {
			listCart = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");
			if (listCart != null) {
				totalQuantity = cartService.totalQuantity(listCart);
			}
		}
		request.setAttribute("totalQuantity", totalQuantity);
		request.setAttribute("listModalCart", listCart);
		return true;
	}

}
