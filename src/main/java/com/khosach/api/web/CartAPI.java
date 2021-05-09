/*
 * @author THUAN-PHAN
 * @date May 23, 2020
 * @version 1.0
 */

package com.khosach.api.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khosach.dto.CartDTO;
import com.khosach.service.ICartService;
import com.khosach.util.CheckUserLogin;
import com.khosach.util.SecurityUtils;

@Controller
public class CartAPI {
	@Autowired
	ICartService cartService;

	@Autowired
	CheckUserLogin checkUserLogin;

	@SuppressWarnings("unchecked")
	@PostMapping("/api/cart/{productID}/{quantity}")
	public ResponseEntity<CartDTO> addCart(@PathVariable(value = "productID", required = false) Long productID,
			@PathVariable(value = "quantity", required = false) Long quantity, HttpSession session) {
		if (checkUserLogin.checkUser()) {// da login
			cartService.addCart(productID, quantity);
		} else {// chua login
			HashMap<Long, CartDTO> listCart = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");
			if (listCart == null) {
				listCart = new HashMap<>();
			}
			session.setAttribute("myCartItems", cartService.addCart(listCart, productID, quantity));
		}

		return ResponseEntity.ok(null);
	}

	@SuppressWarnings("unchecked")
	@PutMapping("api/cart/{productID}/{quantity}")
	public ResponseEntity<CartDTO> updateCart(@PathVariable(value = "productID", required = false) Long productID,
			@PathVariable(value = "quantity", required = false) Long quantity, HttpSession session) {
		if (checkUserLogin.checkUser()) {// da login
			cartService.updateCart(productID, quantity);
		} else {
			HashMap<Long, CartDTO> listCart = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");
			if (listCart == null) {
				listCart = new HashMap<>();
			}
			session.setAttribute("myCartItems", cartService.updateCart(listCart, productID, quantity));

		}
		return ResponseEntity.ok(null);
	}

	@SuppressWarnings("unchecked")
	@DeleteMapping("api/cart/{productID}")
	public ResponseEntity<CartDTO> deleteCart(@PathVariable(value = "productID", required = false) Long productID,
			HttpSession session) {
		if (checkUserLogin.checkUser()) {// da login
			cartService.delete(productID);
		} else {
			HashMap<Long, CartDTO> listCart = (HashMap<Long, CartDTO>) session.getAttribute("myCartItems");
			if (listCart == null) {
				listCart = new HashMap<>();
			}
			session.setAttribute("myCartItems", cartService.deteleCart(listCart, productID));
		}

		return ResponseEntity.ok(null);
	}

	@SuppressWarnings("unchecked")
	@DeleteMapping("api/cart/deleteAll")
	public ResponseEntity<CartDTO> deleteAllCart(HttpSession session) {
		if (checkUserLogin.checkUser()) {// da login
			cartService.deleteAll();
		} else {
			session.setAttribute("myCartItems", new HashMap<>());
		}

		return ResponseEntity.ok(null);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("api/cart")
	public ResponseEntity<?> getCart(HttpSession session) {
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
		List<CartDTO> listCartDTO = new ArrayList<CartDTO>();
		for(long id : listCart.keySet()) {
			listCartDTO.add(listCart.get(id));
		}
		return ResponseEntity.ok(listCartDTO);

	}
}
